package chucknorris.utils

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
