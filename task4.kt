import java.io.File

fun simpleCipher(text: String, shift: Int): String {
    val result = StringBuilder()
    
    for (char in text) {
        if (char.isWhitespace()) {
            result.append(char)
        } else {
            result.append((char.code + shift).toChar())
        }
    }
    
    return result.toString()
}

fun main() {
    println("Оберіть дію:")
    println("1 - Зашифрувати")
    println("2 - Розшифрувати")
    val choice = readln()

    print("Введіть ім'я вхідного файлу: ")
    val inputPath = readln()
    val inputFile = File(inputPath)

    if (!inputFile.exists()) {
        println("Помилка: Файл $inputPath не знайдено!")
        return
    }

    print("Введіть на скільки букв зсунути: ")
    val shift = readln().toIntOrNull() ?: 0 
    val text = inputFile.readText()
    
    val actualShift = if (choice == "1") shift else -shift
    val processedText = simpleCipher(text, actualShift)

    val outFileName = if (choice == "1") "encrypted.txt" else "decrypted.txt"
    val outputFile = File(outFileName)
    
    outputFile.writeText(processedText)
    println("Результат успішно збережено у файл: $outFileName")
}