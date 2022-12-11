package chucknorris

import chucknorris.utils.chuckNorrisToString

fun main() {
    println("Input string:")
    val input = readln()
    val result = chuckNorrisToString(input)
    println("The result:")
    println(result)
}
