/**
 * Класс "Студентський квиток"
 *
 * Цей клас описує інформацію про картку студента
 *
 * @param [_id] Параметр який зберігає айді картки
 * @param [info] Параметр який зберігає опис картки студента
 * @param [student] Параметр який зберігає об'єкт студента
 *
 * @param equals Функція яка допомогає зрівнювати об'єкти класу
 * @param hashCode Функція яка надає об'єкту хеш-код
 * @param toString Функція яка повертає повний опис об'єкту
 *
 * @constructor використовується вбудований конструктор який отримує:
 * @param [student] Параметр який зберігає об'єкт студента
 * */

class StudentTicket(var student: Student) {
    /**
     * Параметр який зберігає айді картки
     * @receiver Параметр має публічний доступ
     * */
    var _id: Long = student._id

    /**
     * Параметр який зберігає назву університета студента
     * */
    var nameUniversity: String = "Київський Політехнічний Інститут ім. Ігоря Сікорського"

    /**
     * Параметр який зберігає назву факультета студента
     * @receiver Параметр має публічний доступ
     * */
    var Faculty: String = "ІАТЕ"

    /**
     * Параметр який зберігає опис картки студента
     * @receiver Параметр має публічний доступ
     * * */
    var info: String =
        "Студентський квиток\n${student.getFullName().replace(" ", "\n")}\n" +
                "$nameUniversity\n${Faculty}\nДійсний до: ${student.calculateTicketExpiryDate()}\n" +
                "Форма навчання: ${student.getFormOfStudying()}"

    /**
     * Функція яка повертає повний опис об'єкту
     * Використовуються усі параметри класу
     * @receiver Функція має публічний доступ
     * @return Функція яка повертає повний опис об'єкту
     * */
    override fun toString(): String {
        return "studentCard(_id=$_id, student=$student, \ninfo='$info')"
    }

    /**
     * Функція яка допомогає зрівнювати об'єкти класу
     * Використовуються усі параметри класу
     * @receiver Функція має публічний доступ
     * @return Функція повертає булиан (об'єкти схожі чи ні)
     * */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudentTicket) return false

        return _id == other._id &&
                student == other.student &&
                info == other.info
    }

    /**
     * Функція яка надає об'єкту хеш-код
     * Використовуються усі параметри класу
     * @receiver Функція має публічний доступ
     * @return Функція повертає число (хеш-код об'єкту)
     * */
    override fun hashCode(): Int {
        return listOf(student, _id, info).hashCode()
    }
}