package chucknorris.utils

private fun toChuckNorrisSequence(char: Char, count: Int): String {
    val prefix = when (char) {
        '0' -> "00"
        '1' -> "0"
        else -> { throw Exception("Unknown character: $char.") }
    }
    return "$prefix ${"0".repeat(count)}"
}

private fun chucknorissize(binary: String): String {
    var currentChar = binary[0]
    var count = 0
    val resultBuffer = mutableListOf<String>()
    for (c in binary) {
        if (c != currentChar) {
            resultBuffer += toChuckNorrisSequence(currentChar, count)
            count = 0
            currentChar = c
        }
        count++
    }
    if (count > 0) {
        resultBuffer += toChuckNorrisSequence(currentChar, count)
    }
    return resultBuffer.joinToString(" ")
}

fun stringToChuckNorris(input: String): String {
    val binary = input.map { intToBinary(it.code) }
    return chucknorissize(binary.joinToString(""))
}
