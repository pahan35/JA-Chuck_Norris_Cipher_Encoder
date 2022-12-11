package chucknorris.utils

import kotlin.math.pow

fun binaryToInt(binary: String): Int {
    var result = 0.0
    val reversed = binary.reversed()
    for (index in reversed.length - 1 downTo 0 ) {
        if (reversed[index] == '1') {
            result += 2.0.pow(index.toDouble());
        }
    }
    return result.toInt()
}

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
