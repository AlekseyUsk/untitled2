import java.awt.Choice

fun main(args: Array<String>) {


    val options = arrayOf("Камень", "Ножницы", "Бумага")

    val gameChoice = getGameChoice(options)

    val userChoise = getUserChoice(options)

    printResult(userChoise, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {

    var isValidChoice = false
    var userChoise = ""

    while (!isValidChoice) {

        println("выберите знак")
        for (item in optionsParam) {
            println("$item ")
            println(" .")
        }
        val userInput = readLine()

        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoise = userInput
        }
        if (!isValidChoice) println("вы выбрали недопустимый вариант")
    }
    return userChoise
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    if (userChoice == gameChoice) result = "Ничия"
    else if ((userChoice == "Камень" && gameChoice == "Ножницы") || (userChoice == "Бумага" && gameChoice == "Камень") || (userChoice == "Ножницы" && gameChoice == "Бумага"))
        result = "ВЫ ПОБЕДИЛИ!!!!!!!!"
    else result = "ВЫ ПРОИГРАЛИ!"
    println("Ваш ход $userChoice ход компьютера $gameChoice  итог $result")
}