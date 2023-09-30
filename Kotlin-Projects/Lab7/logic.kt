/**
 * Клас, що описує методи для роботи з числом:
 *    - обрахунок числа Фібоначі
 *    - обрахунок факторіалу
 *    - обчислення кількості десяткових цифр натурального числа.
 *
 * @param [number] Параметр який зберігає число, який вів користувач
 * @param menu1 Функція яка виводить меню для роботи з числом
 * @param forFibonachi Функція для виводу всіх чисел Фібоначчі
 * включно до введеного числа користувача
 * @param fibonachi Функція яка рахує число Фібоначі
 * @param factorial Функція яка рахує факторіал числа
 * @param sizenum Функція яка рахує кількість цифр в числі
 * */

class Logic() {
    /**
     * Параметр який зберігає число користувача
     * * */
    var number: Int = 0

    /**
     * @param [num] Число, введене користувачем
     * */
    constructor(num: Int) : this() {
        number = num
        val choose = menu1()
        when (choose) {
            1 -> {
                println("Fibonacci numbers for $number: ${forFibonachi(number)}")
            }

            2 -> {
                println("$number! = " + factorial(number))
            }

            3 -> {
                println("$number => " + sizenum(number))
            }
        }
    }

    /**
     * Функція меню
     * @return Функція повертає число (пункт меню який обрав користувач)
     * */
    fun menu1(): Int? {
        println("1. Обчислити Фібоначі\n2. Знайти Факторіал\n3. Обчислення кількості десяткових цифр натурального числа")
        var choose = readLine()?.toInt()
        while (!(choose == 1 || choose == 2 || choose == 3)) choose = readLine()?.toInt()
        return choose
    }

    /**
     * Функція яка допомогаю вивести усі числа Фібоначі включно до,
     * веденого юзером, числа користувача, використовуючи рекурсію
     * @param [n] Число для обробки
     * @return  Результат обрахунку
     * */
    fun forFibonachi(n: Int): String {
        val result = StringBuilder()
        fun helper(n: Int) {
            if (n >= 0) {
                result.append("$n - ${fibonachi(n)}\n")
                helper(n - 1)
            }
        }
        helper(n)
        return result.split("\n").reversed().joinToString("\n")
    }
    /**
     * Функція обрахунку числа Фібоначі, використовуючи рекурсію
     * @param [n] Число для обробки
     * @return Результат обрахунку фібоначі
     * */
    fun fibonachi(n: Int): Int = if (n == 0) 0 else if (n == 1) 1 else fibonachi(n - 1) + fibonachi(n - 2)

    /**
     * Функція яка рахує факторіал числа, використовуючи рекурсію
     * @param [n] Число для обробки
     * @return  Результат обрахунку
     * */
    fun factorial(n: Int): Double = if (n < 2) 1.0 else n * factorial(n - 1)

    /**
     * Функція яка рахує кількість цифр в чіслі
     * @param [n] Число для обробки
     * @return  Результат обрахунку
     * */
    fun sizenum(n: Int): Int {
        var count: Int = 0
        var x: Int = n
        while (x > 0) {
            x /= 10
            count++
        };
        return count
    }
}