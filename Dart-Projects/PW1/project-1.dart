// Клас для визначення всіх показників та для розрахунку складу сухої та горючої маси палива
// та нижчої теплоти згоряння для робочої, сухої та горючої маси за заданим складом компонентів
// палива, що задаються у вигляді значень окремих компонентів типу: Hp%; Cp%; Sp%; Np%; Op%; Wp%; Ap%
class FuelProperties {
  double Hp, Cp, Sp, Np, Op, Ap, Wp;

  FuelProperties(this.Hp, this.Cp, this.Sp, this.Np, this.Op, this.Ap, this.Wp);

  // Розрахуємо коефіцієнт переходу від робочої до сухої маси
  double get Kpc => _calculateKpc(Wp); // Кpc = 100/(100 - Wp)

  double get Hc => _calculateXc(Hp); // Нc = Нp * Кpc
  double get Cc => _calculateXc(Cp); // Cc = Cp * Кpc
  double get Sc => _calculateXc(Sp); // Sc = Sp * Кpc
  double get Nc => _calculateXc(Np); // Nc = Np * Кpc
  double get Oc => _calculateXc(Op); // Oc = Op * Кpc
  double get Ac => _calculateXc(Ap); // Ac = Ap * Кpc

  // Розрахуємо коефіцієнт переходу від робочої до горючої
  double get Kpg => _calculateKpg(Wp, Ap); // КРГ = 100/(100 - Wp -Ap)

  double get Hg => _calculateXg(Hp); // Нc = Нp * КРГ (Kpg)
  double get Cg => _calculateXg(Cp); // Cc = Cp * КРГ (Kpg)
  double get Sg => _calculateXg(Sp); // Sc = Sp * КРГ (Kpg)
  double get Ng => _calculateXg(Np); // Nc = Np * КРГ (Kpg)
  double get Og => _calculateXg(Op); // Oc = Op * КРГ (Kpg)
  double get Ag => _calculateXg(Ap); // Ac = Ap * КРГ (Kpg)

  // Нижча теплота згорання кДж/кг;
  double get Qph => _calculateQph();

  // Нижча теплота згоряння для робочої маси за заданим складом компонентів палива МДж/кг;
  // Qri = (339Сp + 1030Нp - 108,8(Оp - Sp) - 25Wp) / 1000 = Qph / 1000, МДж/кг;
  double get Qri => Qph / 1000;

  // Нижча теплота згоряння для сухої маси за заданим складом компонентів палива МДж/кг;
  double get Qch => _calculateQch(); //
  // Нижча теплота згоряння для сухої маси за заданим складом компонентів палива МДж/кг;

  double get Qgh => _calculateQgh(); //

  // Kpc = 100 / (100 - Wp)
  double _calculateKpc(double wp) => 100 / (100 - wp);

  // Крг = 100 / (100 - Wp - Ap)
  double _calculateKpg(double wp, double ap) => 100 / (100 - wp - ap);

  // Нc = Нp * Кpc
  double _calculateXc(double component) => component * Kpc;

  double _checkXcSum() => Hc + Cc + Sc + Nc + Oc + Ac;

  // Нc = Нp * Kpg
  double _calculateXg(double component) => component * Kpg;

  double _checkXgSum() => Hg + Cg + Sg + Ng + Og;

  // QРН = 339Сp + 1030Нp - 108,8(Оp - Sp) - 25Wp, кДж/кг;
  double _calculateQph() => 339 * Cp + 1030 * Hp - 108.8 * (Op - Sp) - 25 * Wp;

  // Qch = (Qri + 0.025Wp) * 100 / (100 - Wp)
  double _calculateQch() => (Qri + 0.025 * Wp) * 100 / (100 - Wp);

  // Qgh = (Qri + 0.025Wp) * 100 / (100 - Wp - Ap)
  double _calculateQgh() => (Qri + 0.025 * Wp) * 100 / (100 - Wp - Ap);

  @override
  String toString() {
    return '''
    Розрахуємо склад сухої та горючої маси палива та нижчої теплоти згоряння для робочої, сухої та горючої маси за 
    заданим складом компонентів палива: Hp = $Hp%; Cp = $Cp%; Sp = $Sp%; Np = $Np%; Op = $Op%; Wp = $Wp%; Ap = $Ap%;
    -----------------------------
    Розрахуємо коефіцієнт переходу від робочої до сухої маси
    та коефіцієнт переходу від робочої до горючої згідно табл. 1.1:
    Kpc = ${Kpc.toStringAsFixed(2)}
    Kрг = ${Kpg.toStringAsFixed(2)}
    
    Hc = ${Hc.toStringAsFixed(2)}; Cc = ${Cc.toStringAsFixed(2)}
    Sc = ${Sc.toStringAsFixed(2)}; Nc = ${Nc.toStringAsFixed(2)}
    Oc = ${Oc.toStringAsFixed(2)}; Ac = ${Ac.toStringAsFixed(2)}
    ПЕРЕВІРКА: НС + СС + SC + NС + ОС + АС = ${_checkXcSum()}%
            --------------
    Hг = ${Hg.toStringAsFixed(2)}; Cг = ${Cg.toStringAsFixed(2)}
    Sг = ${Sg.toStringAsFixed(2)}; Nг = ${Ng.toStringAsFixed(2)}
    Oг = ${Og.toStringAsFixed(2)}; Aг = ${Ag.toStringAsFixed(2)}
    ПЕРЕВІРКА: Нг + Сг + Sг + Nг + Ог = ${_checkXgSum()}%
    -----------------------------
    Розрахуємо нижчу теплоту згорання (за формулою 1.2):
    Qрн = ${Qph.toStringAsFixed(2)} [кДж/кг] = ${Qri.toStringAsFixed(4)}[МДж/кг]
    -----------------------------
    Перерахуємо дану теплоту на суху та горючу маси за таблицею 1.2:
    Qсн: ${Qch.toStringAsFixed(2)} [МДж/кг]
    Qгн: ${Qgh.toStringAsFixed(2)} [МДж/кг]''';
  }
}

void main() {
  print('Розрахуємо склад сухої та горючої маси палива та нижчої теплоти згоряння'
      'для робочої,сухої та горючої маси за заданим складом компонентів палива:\n\n'
      'Результати перевірки на контрольному прикладі:\n HP=1,9%; CP=21,1%; SP=2,60%;NP=0,20%; OP=7,10%; WP=53,0%; AP=14,1.\n');
  print(FuelProperties(1.9, 21.1, 2.6, 0.2, 7.1, 14.1, 53.0));
  print('\n\n\n\nВаріант 4:\nHP=3.4%; CP=70.6%; SP=2.70%;NP=1.20%; OP=1.90%; WP=5.0%; AP=15.2.\n');
  print(FuelProperties(3.4, 70.6, 2.70, 1.20, 1.90, 5.0, 15.2));
}
