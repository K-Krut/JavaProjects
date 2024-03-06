import 'fuel-data-types.dart';
import 'tables-data.dart';


const double NominalSteamOutput = 950; // Номінальна паропродуктивність котла енергоблока становить 950 т/год,
const double AverageActualSteamOutput = 760; // середня фактична паропродуктивність – 760 т/год.
const double avin = 0.8; // Відкрита топка з рідким шлаковидаленням
const double nuzy = 0.985; // ефективність очищення димових газів від твердих частинок;

// За даними елементного та технічного аналізу склад робочої маси вугілля
const Map<String, dynamic> workingCoalCompositionData = {
  'Cr': 52.49, // вуглець (Cr)
  'Hr': 3.50, // водень (Hr)
  'Or': 4.99, // кисень (Or)
  'Nr': 0.97, // азот (Nr)
  'Sr': 2.85, // сірка (Sr)
  'Ar': 25.20, // зола (Ar)
  'Wr': 10.00, // волога (Wr)
  'Vr': 25.92, // леткі речовини (Vr)
};

// Клас для розрахунку валових викидів шкідливих речовин
// у вигляді суспендованих твердих частинок при спалювання вугілля, мазуту та природного газу
class EmissionsCalculations {
  List<dynamic> gas, mazut, gasNatural;
  Map<String, dynamic> workingCoalComp;
  EmissionsCalculations(this.gas, this.mazut, this.gasNatural, this.workingCoalComp);

  Map<String, dynamic> get gasProperties => coalProperties[gas[0]] ?? {};
  Map<String, dynamic> get gasMetals => coalMetals[gas[0]] ?? {};
  Map<String, dynamic> get mazutProperties => mazutPropertiesData[mazut[0]] ?? {};
  Map<String, dynamic> get gasNaturalProperties => gasComposition[gasNatural[0]] ?? {};
  double ArMazut = 0.15; // зола (Ar)
  double Qch = 20.47; // Нижча теплота згоряння робочої маси вугілля
  double QchMazut = 39.48; // Нижча теплота згоряння мазуту на робочу масу для робочої маси
  double QchNaturalGas = 44.78;
  double Gvin = 1.5; // масовий вміст горючих речовин у леткій золі Гвин
  double GvinMazut = 0; // Масовий вміст горючих речовин у викиді твердих частинок Гвин
  double Gshl = 0.5; // масовий вміст горючих речовин у шлаці Гшл
  double Qidaf = 40.40; // нижча теплота згоряння горючої маси мазуту
  double Wrwork = 2.0; // вологість робочої маси палива
  double Ad = 0.15; // зольність сухої маси
  double V = 333.3; // вміст ванадію (V)

  // Показник емісії твердих частинок при спалюванні вугілля
  double get KtvGas => 1000000 / Qch * avin * (workingCoalComp['Ar'] / (100 - Gvin) * (1 - nuzy));
  // валовий викид при спалюванні вугілля
  double get EtvGas => 0.000001 * KtvGas * Qch * gas[1];

  // Показник емісії твердих частинок при спалюванні мазуту
  double get KtvMazut => 1000000 / QchMazut * 1 * (0.15 / (100 - GvinMazut) * (1 - nuzy));
  // валовий викид при спалюванні мазуту
  double get EtvMazut => 0.000001 * KtvMazut * QchMazut * mazut[1];

  // Показник емісії твердих частинок при спалюванні природного газу
  double get KtvNaturalGas => 1000000 / QchMazut * 1 * (0 / (100 - GvinMazut) * (1 - nuzy)); // double get KtvNaturalGas => 0.0001 * (1 - 0.36);
  // валовий викид при спалюванні природного газу
  double get EtvNaturalGas => 0.000001 * KtvNaturalGas * QchNaturalGas * gasNatural[1];

  // функція для виводу елементів
  String toStringComponents(Map<String, dynamic> component) {
    return '    ' + component.entries .map((entry) => '${entry.key} - ${entry.value.toStringAsFixed(2)};').join('\n        ');
  }

  // функція для виводу елементів по двоє
  String toStringComponentsBy2(Map<String, dynamic> component) {
    return component.entries
        .map((e) => '${e.key} - ${e.value.toStringAsFixed(2)}')
        .toList()
        .asMap()
        .map((i, value) => MapEntry(i, i % 2 == 0 ? '    $value' : value))
        .values
        .toList()
        .fold<List<String>>([], (list, current) {
      if (list.isEmpty || list.last.split('; ').length >= 2) {
        list.add(current);
      } else {
        list[list.length - 1] += '; $current';
      }
      return list;
    }).join(';\n    ');
  }

  // функція для виводу елементів складу робочої маси вугілля
  String toStringWorkingCoalComposition() {
    return toStringComponentsBy2(workingCoalCompositionData);
  }

  // функція для виводу елементів складу горючої маси мазуту
  String toStringWorkingMazutComposition({MazutType = MazutGrade.HighPurity40}) {
    return toStringComponents(mazutPropertiesData[MazutType]!);
  }

  // функція для виводу елементів складу горючої маси мазуту з описом параметрів
  String getMazutPropertiesDescription({grade = MazutGrade.HighPurity40}) {
    final prop = mazutPropertiesData[grade];
    if (prop == null) {
      return 'Дані для даної марки мазута відсутні';
    }

    return mazutPropertiesDescription.entries.map((entry) {
      if (prop[entry.key] == null) {
        return null;
      }
      return '    ' + '${entry.value} – ${prop[entry.key] is double ? prop[entry.key].toStringAsFixed(2) : prop[entry.key]}';
    }).where((line) => line != null).join('\n    ');
  }

  // функція для виводу елементів складу сухої маси природного газу
  String toStringWorkingNaturalGasComposition({GasType = GasPipeline.UrengoyUzhgorod}) {
    return toStringComponentsBy2(gasComposition[GasType]!);
  }

  // функція для виводу інформації по обрахункам
  @override
  String toString() {
    return '''
    Енергоблок з котлом, призначеним для факельного спалювання вугілля з високим вмістом летких, типу газового або довгополуменевого, з рідким шлаковидаленням. 
    Номінальна паропродуктивність котла енергоблока становить $NominalSteamOutput т/год, а середня фактичнапаропродуктивність – $AverageActualSteamOutput т/год. 
    На ньому застосовується ступенева подача повітря та рециркуляція димових газів. Пароперегрівачі котла очищуються при зупинці блока. Для уловлювання твердих 
    частинок використовується електростатичний фільтр типу ЕГА з ефективністю золовловлення $nuzy.
    -----------------------------
    Установки для очищення димових газів від оксидів азоту та сірки відсутні. За звітний період використовувалось таке паливо:
    - донецьке газове вугілля марки ГР – ${gas[1]} т;
    - високосірчистий мазут марки 40 – ${mazut[1]} т;
    - природний газ із газопроводу Уренгой-Ужгород – ${gasNatural[1]} тис. м3
    За даними елементного та технічного аналізу склад робочої маси вугілля наступний, %:
    ${toStringWorkingCoalComposition()}
    -----------------------------
    Нижча теплота згоряння робочої маси вугілля становить $Qch МДж/кг. Масовий вміст горючих речовин у леткій золі Гвин = $Gvin%, а в шлаці Гшл = $Gshl%.
    За даними таблиці А.3 (додаток А) склад горючої маси мазуту наступний, %:
    ${getMazutPropertiesDescription()}
    За даними таблиці А.3 (додаток А) об’ємний склад сухої маси природного газу становить, %:
    ${toStringWorkingNaturalGasComposition()}
    -----------------------------
    1. Розрахуємо валовий викид твердих частинок при спалюванні вугілля
    Сіркоочисна установка відсутня, тому викиду твердих частинок сорбенту та продуктів взаємодії сорбенту та оксидів сірки немає. Гвин = $Gvin%, ηзу = $nuzy.
      Показник емісії твердих частинок при спалюванні вугілля
          kтв = ${KtvGas.toStringAsFixed(2)} [г/ГДж]
      Валовий викид при спалюванні вугілля
          Eтв = ${EtvGas.toStringAsFixed(2)} [т]
    2. Розрахуємо валовий викид твердих частинок при спалюванні мазуту.
    Викиду твердих частинок сорбенту та продуктів взаємодії сорбенту та оксидів сірки немає. Гвин становить $GvinMazut%, ηзу = $nuzy.
      Показник емісії твердих частинок при спалюванні мазуту
          kтв = ${KtvMazut.toStringAsFixed(2)} [г/ГДж]
      Валовий викид при спалюванні мазуту
          Eтв = ${EtvMazut.toStringAsFixed(2)} [т]
    3. Розрахуємо валовий викид твердих частинок при спалюванні природного газу.
    При спалюванні природного газу тверді частинки відсутні! Ar – масовий вміст золи в паливі на робочу масу = 0. Гвин становить $GvinMazut%
      Показник емісії твердих частинок при спалюванні природного газу
          kтв = ${KtvNaturalGas.toStringAsFixed(2)} [г/ГДж]
      Валовий викид при спалюванні природного газу
          Eтв = ${EtvNaturalGas.toStringAsFixed(2)} [т]\n\n\n''';
  }
}

void main() {
  //Контрольний приклад
  EmissionsCalculations emissionsExample = EmissionsCalculations(
      [CoalType.DonetskGasTR, 1096363],
      [MazutGrade.HighPurity40, 70945],
      [GasPipeline.UrengoyUzhgorod, 84762],
      workingCoalCompositionData
  );
  print(emissionsExample);

  // Варіант №4
  EmissionsCalculations emissions = EmissionsCalculations(
      [CoalType.DonetskGasTR, 672419.96],
      [MazutGrade.HighPurity40, 111633.33],
      [GasPipeline.UrengoyUzhgorod, 128674.68],
      workingCoalCompositionData
  );
  print(emissions);
}