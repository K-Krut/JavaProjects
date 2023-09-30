fun main(args: Array<String>) {
    // Створюємо об'єкт студента
    val student1 = Student(
        "Борис",
        "Ткаченко",
        "Іванович",
        21,
        4,
        "TI-01",
        "121",
        StudyForm.FULL_TIME
    )
    println(student1)
    // Створюємо об'єкт картки студента
    val ticketStudent1 = StudentTicket(student1)
    println(ticketStudent1)

    val student2 = Student("Іван", "Іванов", "Іванович", 20, 3, "КН-301", "131", StudyForm.FULL_TIME)
    val student3 = Student("Іван", "Іванов", "Іванович", 20, 3, "КН-301", "131", StudyForm.FULL_TIME)
    val student4 = Student("Петро", "Петров", "Петрович", 21, 2, "КН-202", "122", StudyForm.PART_TIME)

    println(student2 == student3)
    println(student2 == student4)
}


