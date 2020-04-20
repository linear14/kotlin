package kotlin_in_action_ch06

// null 검사를 java에서는 이런 느낌으로 할 수 있지?
// 코틀린에서는 최대한 간결하게 사용한다. (다음 챕터에서부터) (if사용이 최소화 됨)
fun main() {
    fun strLenSafe(s: String?): Int =
        if(s != null) s.length else 0

    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))
}