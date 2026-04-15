fun main() {
    val deck = listOf("6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз")
    val hiddenCards = deck.shuffled().take(3) 
    
    println("Гра: Вгадай хоча б 1 з 3 закритих карт")
    println("Було покладено на стіл 3 закриті карти")
    println("Можливі варіанти: 6, 7, 8, 9, 10, Валет, Дама, Король, Туз")
    print("Обери свій варіант: ")
    
    val guess = readln()
    val isWinner = hiddenCards.any { it.equals(guess, ignoreCase = true) }
    
    if (isWinner) {
        println("\nТи вгадав")
    } else {
        println("\nТи не вгадав")
    }   
    println("Закритими картами були: ${hiddenCards.joinToString(", ")}")
}