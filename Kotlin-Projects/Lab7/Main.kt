fun main(args: Array<String>) {
    try {
        // Параметр для того щоб програма не вимикалась
        var quit = "wait"
        // цикл для того, щоб програма не вимикалась сама
        while (!(quit == "q")) {
            println("число для обробки:")
            // користувач водить число, яке ми потім перевіряємо щоб воно було Натуральне
            var choose = readLine()?.toInt()
            var ind = true
            while (ind) {
                if (choose != null) if (choose <= 0) {
                    println("число має бути > 0")
                    choose = readLine()?.toInt()
                } else ind = false
            }
            if (choose != null) {
                Logic(choose)
            }
            println("'q' - quit, anything - continue")
            quit = readLine()?.toString().toString()
        }
    } catch (e: Exception) {
        // якщо введено не є цифри / знак мінус -- виводимо помилку
        println("Помилка вводу")
    }
}

