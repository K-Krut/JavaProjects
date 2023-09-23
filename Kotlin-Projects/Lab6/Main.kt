import java.lang.Math.pow
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.*

// Оголошення констатнт
const val ENTER_A = "Ведіть значення а: ";
const val ENTER_B = "Ведіть значення b: ";
const val ENTER_C = "Ведіть значення c: ";
const val ENTER_D = "Ведіть значення d: ";
const val ENTER_X = "Ведіть значення x: ";
const val ENTER_Y = "Ведіть значення y: ";

/**
 * Головна функція програми. Інтерфейс програми
 */
fun main(args: Array<String>) {
    println("Choose option:")
    try {
        var quit = "wait"
        // цикл для того, щоб програма не вимикалась сама
        while (!(quit == "q")) {
            val choose = menu1() // меню для вибору ходу програми / завдання
            when (choose) { // обрахунок вибраного варіанту
                1 -> {
                    val choose2 = menu2()
                    when (choose2) {
                        1 -> {
                            println(calculateMax())
                        }
                        2 -> {
                            println(calculateXPowY())
                        }
                        3 -> {
                            println(calculateQuadraticEquationY())
                        }
                    }
                }
                2 -> {
                    val choose3 = menu3()
                    when (choose3) {
                        1 -> {
                            println(calculateXPow())
                        }
                        2 -> {
                            println(calculateQuadraticEquation())
                        }
                        3 -> {
                            println(calculateLinearEquation())
                        }
                    }
                }
            }
            println("Для завершення 'q', інакше -- будь що")
            quit = readLine()?.toString().toString()
        }
    } catch (e: Exception) {
        // Якщо користувач вводить літери або якісь символи, які не є цифрами та знаком мінус то буде помилка
        println("#ERROR: Введено некорректні данні")
    }
}

/**
 * Функція підрахунку значеня Y
 * Функція підрахнку: у=МАХ(a, b, c, d)
 */
fun calculateMax(): String {
    // зчитування змінних для обрахунку
    val a = readDouble(ENTER_A)
    val b = readDouble(ENTER_B)
    val c = readDouble(ENTER_C)
    val d = readDouble(ENTER_D)
    // перевірка значень на коректність
    if (d != null && a != null && b != null && c != null) {
        // повернення результату обрахунку
        return "y = MAX(a, b, c, d) = MAX(${a}, ${b}, ${c}, ${d}) = ${max(a, b, c, d)}"
    }
    // помилка у разі некорректності даних
    return "#ERROR: Якесь значення введено некорректно, помилка обрахунку"
}

/**
 * Функція підрахунку значеня Y
 * Функція підрахнку: y = x^4
 */
fun calculateXPowY(): String {
    val x = readDouble(ENTER_X)
    // використання функції pow із стандартної бібліотеки для підрахунку степення
    return "y = x^4 = x^${x} = " + x?.let { pow(it, 4.0) }
}

/**
 * Функція підрахунку значеня Y
 * Функція підрахнку: y = ax^2 + bx + c
 */
fun calculateQuadraticEquationY(): String {
    val a = readDouble(ENTER_A)
    val x = readDouble(ENTER_X)
    val b = readDouble(ENTER_B)
    val c = readDouble(ENTER_C)
    // перевірка значень на коректність
    if (x != null && a != null && b != null && c != null) {
        // повернення результату обрахунку
        return "y = ax^2 + bx + c = ${a}*${x}^2 + ${b}*${x} + $c = " + (pow(x, 2.0) * a + b * x + c)
    }
    // помилка у разі некорректності даних
    return "#ERROR: Якесь значення введено некорректно, помилка обрахунку"
}

/**
 * Функція підрахунку значеня X
 * Функція підрахнку: y = ax^2 + bx + c;
 */
fun calculateQuadraticEquation(): String {
    // зчитування змінних для обрахунку
    val a = readDouble(ENTER_A)
    val y = readDouble(ENTER_Y)
    val b = readDouble(ENTER_B)
    val c = readDouble(ENTER_C)
    // Виклик функції для обрахунку квдратних коренів рівняння
    return square(a, y, b, c)
}

/**
 * Функція підрахунку значеня X
 * Функція підрахнку: y = x^4;
 */
fun calculateXPow(): String {
    // зчитування змінних для обрахунку
    val y = readDouble(ENTER_Y)
    // обрахунок значення
    val res = y?.let { pow(it, 0.25) }
    // повернення результатів
    return "y = x^4; y = ${y}; => x1 = ${res?.let { round2(it) }}; x2 = ${round2(-res!!)}"
}

/**
 * Функція підрахунку значеня X
 * Функція підрахнку: y = ax + c;
 */
fun calculateLinearEquation(): String {
    // зчитування змінних для обрахунку
    val y = readDouble(ENTER_Y)
    val a = readDouble(ENTER_A)
    val c = readDouble(ENTER_C)
    // перевірка особливого кейсу в рівнянні
    if (a == 0.0) {
        return "Немає розв'язку"
    }
    // повернення результатів обрахнку
    return "y = ax + c; $y = ${a}x + ${c}; => x = " + ((y!! - c!!) / a!!)
}

/**
 * Функція для обрахнку коренів квадратного рівняння y = ax^2 + bx + c;
 * @param a - значення параметра а у рівнянні y = ax^2 + bx + c;
 * @param y - значення функції у рівнянні y = ax^2 + bx + c;
 * @param b - значення параметра b у рівнянні y = ax^2 + bx + c;
 * @param c - значення параметра c у рівнянні y = ax^2 + bx + c;
 */
fun square(a: Double?, y: Double?, b: Double?, c: Double?): String {
    val sd = discriminant(a, b, c)?.let { sqrt(it) }
    if (sd != null) {
        if (sd > 0.0) {
            val x1 = (-b!! + sd) / (2 * a!!)
            val x2 = (-b - sd) / (2 * a)
            return "y = ax^2 + bx + c; $y = ${a}x^2 + ${b}x + ${c}; => x1 = ${round2(x1)}, x2 = ${round2(x2)}";
        } else if (sd == 0.0) {
            val x = -b!! / (2 * a!!)
            return "y = ax^2 + bx + c; $y = ${a}x^2 + ${b}x + ${c}; => x = ${round2(x)}";
        } else return "Нема коренів";
    }
    return "Нема коренів";
}

/**
 * Функція для зчитування значення введеного юзером
 */
fun readDouble(prompt: String): Double? {
    print(prompt)
    return readLine()?.toDoubleOrNull()
}

/**
 * Функція для обрахунку дискримінанта квадратного рівняння
 */
fun discriminant(a: Double?, b: Double?, c: Double?): Double? =
    if (b != null) b * b - 4 * (a ?: 0.0) * (c ?: 0.0) else null

/**
 * Функція для знаходження максимального значення
 */
fun max(a: Double, b: Double, c: Double, d: Double): Double {
    var res = a
    if (b > res) res = b
    if (c > res) res = c
    if (d > res) res = d
    return res
}

/**
 * Функція для заукруглювання результатів обчислення до двух знаків після коми
 */
fun round2(number: Double): Double? {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(number).toDouble()
}

/**
 * Функція для виклику головного меню
 */
fun menu1(): Int? {
    println("1. Обчислити значення.\n2. Розв'язати рівняння.")

    var choose = readLine()?.toInt()
    while (!(choose == 1 || choose == 2)) choose = readLine()?.toInt()
    return choose
}

/**
 * Функція для виклику меню пешого пункту
 */
fun menu2(): Int? {
    println("1. y = MAX(a, b, c, d)\n2. y = x^4\n3. y = ax^2 + bx + c")
    var choose = readLine()?.toInt()
    while (!(choose == 1 || choose == 2 || choose == 3)) choose = readLine()?.toInt()
    return choose
}

/**
 * Функція для виклику меню другого пункту
 */
fun menu3(): Int? {
    println("1. y = x^4\n2. y = ax^2 + bx + c\n3. y = ax + c")
    var choose = readLine()?.toInt()
    while (!(choose == 1 || choose == 2 || choose == 3)) choose = readLine()?.toInt()
    return choose
}