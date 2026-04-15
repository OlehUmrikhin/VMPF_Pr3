import java.io.File

fun main() {
    println("Введіть шлях до файлу (test.txt):")
    val filePath = readln()
    val file = File(filePath)

    if (!file.exists()) {
        println("Помилка: Файл $filePath не знайдено")
        return
    }
    val text = file.readText()
    var letterCount = 0
    var spaceCount = 0
    var signCount = 0

    for (char in text) {
        when {
            char.isLetter() -> letterCount++
            char.isWhitespace() -> spaceCount++ 
            else -> signCount++ 
        }
    }

    println("Кількість літер: $letterCount")
    println("Кількість пробілів: $spaceCount")
    println("Кількість інших знаків: $signCount")
    println("Загальна кількість символів: ${text.length}")
}