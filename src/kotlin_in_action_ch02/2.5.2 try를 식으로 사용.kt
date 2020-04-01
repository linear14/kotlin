package kotlin_in_action_ch02

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main() {
    fun readNumber(reader: BufferedReader) {
        val number = try {
            Integer.parseInt(reader.readLine())
        } catch (e: NumberFormatException) {
            "error"
        }
        println(number)
    }

    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)
}