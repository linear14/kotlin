package kotlin_in_action_ch02

import java.util.*

fun main() {

    // 1번 예제
    println("1번 예제")
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // 2번 예제
    println("\n2번 예제")
    val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()){
        println("$index : $element")
    }

    // 3번 예제
    println("\n3번 예제")
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'

    println(isLetter('d'))
    println(isNotDigit('3'))

    // 4번 예제
    println("\n4번 예제")
    println("Kotlin" in "Java".."Scala")
}

