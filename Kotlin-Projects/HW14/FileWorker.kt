import java.io.File

/**
 * Повний шлях до папки resources з файлами для тестування
 */
const val ROOT_URL = "/Users/katiakrut/IdeaProjects/KotlinProjects/Homework14/src/main/resources"


/**
 * Клас для роботи з файлами
 */
class FileWorker(private val choose: Int = 0) {

    /**
     * Замінює підстрічку в файлі заданою стрічкою.
     * Якщо файл не існує, повертає "File does not exist" повідомлення.
     */
    fun fileReplace() {
        val file = openFile() ?: return println("File does not exist")
        println("Введіть підстрічку для заміни: ")
        val txt1 = readLine() ?: ""
        println("Введіть підстрічку, на яку замінити: ")
        val txt2 = readLine() ?: ""
        file.writeText(file.readText().replace(txt1, txt2))
        println("Done!")
    }

    /**
     * Створює копію файлу з розширенням .bak.
     * Якщо файл не існує, повертає "File does not exist" повідомлення.
     * Якщо файл з такою назвою вже існує, повертає "#ERROR - файл вже є!" повідомлення.
     */
    fun bak() {
        val file = openFile() ?: return println("File does not exist")
        println("Enter file name!")
        val newFile = File("$ROOT_URL/${readLine()}.bak")
        if (newFile.createNewFile()) {
            newFile.writeText(file.readText())
            println("Done!")
        } else {
            println("#ERROR - файл вже є!")
        }
    }

    /**
     * Формує два нових файли: один з непарних рядків вихідного файлу, інший - з парних.
     * Якщо вихідний файл не існує, повертає "File does not exist" повідомлення.
     */
    fun oddAndEvenFiles() {
        val file = openFile() ?: return println("File does not exist")
        val lines = file.readLines()
        val oddLines = lines.filterIndexed { index, _ -> index % 2 == 0 }
        val evenLines = lines.filterIndexed { index, _ -> index % 2 != 0 }
        File(newFile()).writeText(oddLines.joinToString("\n"))
        File(newFile()).writeText(evenLines.joinToString("\n"))
        println("Done!")
    }

    /**
     * Шифрує або розшифровує вміст файлу використовуючи ключ.
     * Якщо файл не існує, повертає "File does not exist" повідомлення.
     * @param choose Визначає режим роботи: 1 для шифрування, 2 для розшифровки.
     */
    fun cipher() {
        val file = openFile() ?: return println("File does not exist")
        println("Enter key. Example: 'key'")
        val key = readLine() ?: ""
        val lines = file.readLines()
        val processedLines = when (choose) {
            1 -> lines.filter { it.isNotEmpty() }.map { Cipher().encryption(it, key) }
            2 -> lines.filter { it.isNotEmpty() }.map { Cipher().decryption(it, key) }
            else -> lines
        }
        File(newFile()).writeText(processedLines.joinToString("\n"))
        println("Done!")
    }

    /**
     * Відкриває файл для читання.
     * Якщо файл не існує, повертає `null` і виводить повідомлення про помилку -- "#ERROR - файл не існує".
     * @return Об'єкт File | `null`.
     */
    private fun openFile(): File? {
        println("Opening file!\nВедіть filename без формату: ")
        val fileName = "$ROOT_URL/${readLine()}.txt"
        return File(fileName).takeIf { it.exists() } ?: run {
            println("#ERROR - файл не існує")
            null
        }
    }

    /**
     * Створює новий файл і повертає шлях до нього.
     * Якщо файл вже існує, виводить повідомлення про помилку -- "#ERROR - файл вже є!".
     * @return Шлях до створеного файлу.
     */
    private fun newFile(): String {
        println("Введіть filename без формату:")
        val fileName = "$ROOT_URL/${readLine()}.txt"
        println(File(fileName).takeIf { it.createNewFile() }?.let { "File created!" } ?: "#ERROR - файл вже є!")
        return fileName
    }
}
