package chucknorris

fun intToBinary(number: Int): String {
    val reminders = mutableListOf<Int>()
    var quotient = number
    do {
        reminders.add(quotient % 2)
        quotient /= 2
    } while (quotient > 0)
    reminders.reverse()
    if (reminders.size < 7) {
        reminders.add(0, 0)
    }
    return reminders.joinToString("")
}

fun toChuckNorrisSequence(char: Char, count: Int): String {
    val prefix = when (char) {
        '0' -> "00"
        '1' -> "0"
        else -> { throw Exception("Unknown character: $char.") }
    }
    return "$prefix ${"0".repeat(count)}"
}

fun chucknorissize(binary: String): String {
    var currentChar = binary[0]
    var count = 0
    val resultBuffer = mutableListOf<String>()
    for (c in binary) {
        if (c != currentChar) {
            resultBuffer.add(toChuckNorrisSequence(currentChar, count))
            count = 0
            currentChar = c
        }
        count++
    }
    if (count > 0) {
        resultBuffer.add(toChuckNorrisSequence(currentChar, count))
    }
    return resultBuffer.joinToString(" ")
}

fun main() {
    println("Input string:")
    val input = readln()
    val binary = input.map { intToBinary(it.code) }
    val chucknorissized = chucknorissize(binary.joinToString(""))
    println("The result:")
    println(chucknorissized)
}