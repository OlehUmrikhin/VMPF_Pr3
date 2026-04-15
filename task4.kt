import java.io.File

// Універсальна функція для шифрування та дешифрування
fun simpleCipher(text: String, shift: Int): String {
    val result = StringBuilder()
    
    for (char in text) {
        // Пробіли та перенесення рядків (Enter) не чіпаємо
        if (char.isWhitespace()) {
            result.append(char)
        } else {
            // Зсуваємо код символу на заданий ключ
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

    println("Введіть ім'я вхідного файлу (secret.txt): ")
    val inputPath = readln()
    val inputFile = File(inputPath)

    if (!inputFile.exists()) {
        println("Помилка: Файл $inputPath не знайдено!")
        return
    }

    println("Введіть числовий ключ (наприклад, 5):")
    val shift = readln().toIntOrNull() ?: 0 

    val text = inputFile.readText()
    
    // Якщо ми розшифровуємо, то зсув має бути у зворотний бік (від'ємний)
    val actualShift = if (choice == "1") shift else -shift
    val processedText = simpleCipher(text, actualShift)

    // Створюємо новий файл для результату
    val outFileName = if (choice == "1") "encrypted.txt" else "decrypted.txt"
    val outputFile = File(outFileName)
    
    // Записуємо оброблений текст у новий файл
    outputFile.writeText(processedText)
    println("Результат успішно збережено у файл: $outFileName")
}