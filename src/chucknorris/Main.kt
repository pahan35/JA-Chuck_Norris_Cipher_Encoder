package chucknorris

import chucknorris.utils.chuckNorrisToString

fun main() {
    println("Input string:")
    val input = readln().trim()
    val result = chuckNorrisToString(input)
    println("The result:")
    println(result)
}
