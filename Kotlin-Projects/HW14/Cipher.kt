/**
 * Клас для шифрування та розшифрування тексту методом Віженера
 */
class Cipher(private var text: String = "", private var key: String = "") {
    private val alf = alphabet()

    /**
     * Шифрує вхідний текст за допомогою ключа
     *
     * @param inputText Текст, який потрібно зашифрувати
     * @param inputKey Ключ для шифрування
     * @return Зашифрований текст
     */
    fun encryption(inputText: String, inputKey: String): String {
        key = inputKey
        val textNumbers = convertToNumbers(inputText.lowercase())
        val keyNumbers = convertToNumbers(generateBigKey(inputText.length))

        textNumbers.indices.forEach { i -> textNumbers[i] += keyNumbers[i] }

        return buildString {
            textNumbers.forEach { value ->
                val adjustedValue = if (value >= alf.length) value - alf.length else value
                append(alf[adjustedValue])
            }
        }
    }

    /**
     * Розшифровує вхідний текст за допомогою ключа
     *
     * @param inputText Текст, який потрібно розшифрувати
     * @param inputKey Ключ для розшифрування
     * @return Розшифрований текст
     */
    fun decryption(inputText: String, inputKey: String): String {
        key = inputKey
        val textNumbers = convertToNumbers(inputText.lowercase())
        val keyNumbers = convertToNumbers(generateBigKey(inputText.length))

        textNumbers.indices.forEach { i -> textNumbers[i] -= keyNumbers[i] }

        return buildString {
            textNumbers.forEach { value -> append(alf[if (value < 0) alf.length + value else value]) }
        }
    }

    /**
     * Генерує алфавіт для шифрування та розшифрування
     * @return Стрічка, яка містить алфавіт
     */
    private fun alphabet() = buildString {
        append(" ")
        append(('a'..'z').joinToString(""))
    }

    /**
     * Генерує ключ необхідної довжини для шифрування/розшифрування
     * @param length Довжина потрібного ключа
     * @return Стрічка, яка містить ключ необхідної довжини
     */
    private fun generateBigKey(length: Int) = buildString {
        repeat((length + key.length - 1) / key.length) { append(key) }
    }.take(length)


    /**
     * Конвертує вхідний текст у числове представлення на основі алфавіту
     * @param input Вхідний текст для конвертації
     * @return Масив цілих чисел, який представляє текст
     * @throws IllegalArgumentException Якщо символ відсутній в алфавіті
     */
    private fun convertToNumbers(input: String) = IntArray(input.length) {
        val index = alf.indexOf(input[it])
        if (index == -1) throw IllegalArgumentException("Символ '${input[it]}' відсутній в алфавіті!")
        index
    }
}
