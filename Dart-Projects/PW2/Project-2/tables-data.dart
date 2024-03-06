import 'fuel-data-types.dart';

// Таблиця А.1. Елементний склад вугілля (масовий вміст на горючу масу)
const Map<CoalType, Map<String, dynamic>> coalProperties = {
  CoalType.AnthraciteAsh: {
    'C': 93.5,
    'H': 1.8,
    'S': 2.4,
    'O': 1.5,
    'N': 0.8,
    'V': 4.0,
    'Q': 33.24
  },
  CoalType.LeanCoalTR: {
    'C': 89.0,
    'H': 4.2,
    'S': 3.3,
    'O': 2.1,
    'N': 1.5,
    'V': 12.0,
    'Q': 34.29
  },
  CoalType.DonetskGasTR: {
    'C': 81.0,
    'H': 5.4,
    'S': 4.4,
    'O': 7.7,
    'N': 1.5,
    'V': 40.0,
    'Q': 31.98
  },
  CoalType.DonetskLongFlameTR: {
    'C': 75.5,
    'H': 5.5,
    'S': 4.3,
    'O': 13.1,
    'N': 1.6,
    'V': 43.0,
    'Q': 30.56
  },
  CoalType.LvivVolynJVB: {
    'C': 79.5,
    'H': 5.2,
    'S': 3.7,
    'O': 10.3,
    'N': 1.3,
    'V': 39.0,
    'Q': 31.69
  },
  CoalType.OleksandriyaBrownJVB: {
    'C': 67.5,
    'H': 5.8,
    'S': 5.9,
    'O': 19.9,
    'N': 0.9,
    'V': 58.5,
    'Q': 26.96
  }
};

// Таблиця А.2. Вміст важких металів свм у енергетичному вугіллі, мг/кг
const Map<CoalType, Map<String, dynamic>> coalMetals = {
  CoalType.AnthraciteAsh: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.28,
    'Ni': 26,
    'Pb': 20,
    'Se': 0,
    'Zn': 40
  },
  CoalType.LeanCoalTR: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.20,
    'Ni': 26,
    'Pb': 18,
    'Se': 0,
    'Zn': 40
  },
  CoalType.DonetskGasTR: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.14,
    'Ni': 26,
    'Pb': 14,
    'Se': 0,
    'Zn': 40
  },
  CoalType.DonetskLongFlameTR: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.16,
    'Ni': 26,
    'Pb': 16,
    'Se': 0,
    'Zn': 40
  },
  CoalType.LvivVolynJVB: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.16,
    'Ni': 26,
    'Pb': 16,
    'Se': 0,
    'Zn': 40
  },
  CoalType.OleksandriyaBrownJVB: {
    'As': 20,
    'Cd': 0,
    'Cr': 47,
    'Cu': 29,
    'Hg': 0.16,
    'Ni': 26,
    'Pb': 14,
    'Se': 0,
    'Zn': 40
  }
};

// Таблиця А.3. Склад енергетичних мазутів
const Map<MazutGrade, Map<String, dynamic>> mazutPropertiesData = {
  MazutGrade.HighPurity40: {
    'S': 2.50,
    'C': 85.50,
    'H': 11.20,
    'ON': 0.80,
    'Q': 40.40,
    'Ad': 0.15,
    'V2O5': 600, // Волога
    'Wr': 2.00, // V2O5
  },
  MazutGrade.HighPurity100: {
    'S': 2.70,
    'C': 85.70,
    'H': 10.60,
    'ON': 1.00,
    'Q': 40.03,
    'Ad': 0.15,
    'V2O5': 600,
    'Wr': 2.00,
  },
  MazutGrade.HighPurity200: {
    'S': 3.00,
    'C': 85.90,
    'H': 10.20,
    'ON': 0.90,
    'Q': 39.77,
    'Ad': 0.30,
    'V2O5': 1200,
    'Wr': 1.00,
  },
  MazutGrade.LowSulfur40: {
    'S': 0.40,
    'C': 87.50,
    'H': 11.50,
    'ON': 0.60,
    'Q': 41.24,
    'Ad': 0.15,
    'V2O5': 600,
    'Wr': 2.00,
  },
  MazutGrade.LowSulfur100: {
    'S': 0.40,
    'C': 87.50,
    'H': 11.10,
    'ON': 1.00,
    'Q': 40.82,
    'Ad': 0.15,
    'V2O5': 600,
    'Wr': 2.00,
  },
};

// Таблиця А.4. Характеристики природного газу для різних газопроводів
const Map<GasPipeline, Map<String, dynamic>> gasComposition = {
  GasPipeline.UrengoyUzhgorod: {
    'CH4': 98.90,
    'C2H6': 0.12,
    'C3H8': 0.011,
    'C4H10': 0.01,
    'C5H12': 0.00,
    'CO2': 0.06,
    'N2': 0.90,
    'H2S': 0.00,
    'Qdi': 33.08,
    'ron': 0.723,
  },
  GasPipeline.CentralAsiaCenter: {
    'CH4': 94.29,
    'C2H6': 2.80,
    'C3H8': 0.73,
    'C4H10': 0.15,
    'C5H12': 0.03,
    'CO2': 1.00,
    'N2': 0.00,
    'H2S': 0.00,
    'Qdi': 34.21,
    'ron': 0.764,
  },
};

const Map<String, dynamic> mazutPropertiesDescription = {
  'S': 'сірка',
  'C': 'вуглець',
  'H': 'водень',
  'ON': 'кисень та азот',
  'Q': 'нижча теплота згоряння горючої маси мазуту дорівнює [МДж/кг]',
  'Ad': 'зольність сухої маси [%]',
  'V2O5': 'мазутна зола (V2O5) [мг/кг]', // Волога
  'Wr': 'вологість робочої маси палива [%]', // V2O5
};