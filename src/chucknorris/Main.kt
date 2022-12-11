package chucknorris

import chucknorris.utils.stringToChuckNorris

fun main() {
    println("Input string:")
    val input = readln()
    val result = stringToChuckNorris(input)
    println("The result:")
    println(result)
}
