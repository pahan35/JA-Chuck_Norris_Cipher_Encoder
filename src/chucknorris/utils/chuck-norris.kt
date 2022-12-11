package chucknorris.utils

private const val BINARY_SEQUENCE_LENGTH = 7

class ChuckNorrisEncodeException : RuntimeException("Encoded string is not valid.")

private fun toChuckNorrisSequence(char: Char, count: Int): String {
    val prefix = when (char) {
        '0' -> "00"
        '1' -> "0"
        else -> {
            throw Exception("Unknown character: $char.")
        }
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

private fun dechucknorissize(chucknorissized: String): String {
    val split = chucknorissized.split(" ")
    var binary = ""
    try {
        for (i in split.indices step 2) {
            val charSequenceLength = split[i].length
            if (charSequenceLength > 2) {
                throw ChuckNorrisEncodeException()
            }
            val baseChar = if (charSequenceLength == 1) "1" else "0"
            binary += baseChar.repeat(split[i + 1].length)
        }
    } catch (e: IndexOutOfBoundsException) {
        throw ChuckNorrisEncodeException()
    }
    return binary
}

fun chuckNorrisToString(input: String): String {
    if (!input.matches("^[0 ]+$".toRegex())) {
        throw ChuckNorrisEncodeException()
    }
    val decodedBinary = dechucknorissize(input)
    if (decodedBinary.length % BINARY_SEQUENCE_LENGTH != 0) {
        throw ChuckNorrisEncodeException()
    }
    val binaries = decodedBinary.chunked(BINARY_SEQUENCE_LENGTH)
    var result = ""
    for (binary in binaries) {
        val charCode = binaryToInt(binary)
        result += Char(charCode)
    }
    return result
}
