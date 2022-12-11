package chucknorris

import chucknorris.utils.ChuckNorrisEncodeException
import chucknorris.utils.chuckNorrisToString
import chucknorris.utils.stringToChuckNorris

fun main() {
    while (true) {
        println("Please input operation (encode/decode/exit):")
        when (val operation = readln().trim()) {
            "encode" -> {
                println("Input string:")
                val input = readln().trim()
                val result = stringToChuckNorris(input)
                println("Encoded string:")
                println(result)
            }
            "decode" -> {
                println("Input encoded string:")
                val input = readln().trim()
                try {
                    val result = chuckNorrisToString(input)
                    println("Decoded string:")
                    println(result)
                } catch (e: ChuckNorrisEncodeException) {
                    println(e.message)
                }
            }
            "exit" -> break
            else -> println("There is no '$operation' operation")
        }
    }
    println("Bye!")
}
