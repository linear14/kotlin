package kotlin_in_action_ch05

// apply 사용
// 수신객체를 반환한다. (여기서는 StringBuilder 객체를 반환함)
// 참고로, 앞서 사용한 with 함수는 람다식 내에서 반환값을 설정했음.
// 인스턴스를 만든 뒤 바로 초기 설정을 해주는 메서드를 만들 때 유용
fun alphabet4() = StringBuilder().apply {
    for(letter in 'A'..'Z') append(letter)
    append("\nNow I know the alphabet!")
}.toString()

// buildString으로 알파벳 만들기
// StringBuilder 와 toString()의 용도를 합친 함수
fun alphabet5() = buildString {
    for(letter in 'A'..'Z') append(letter)
    append("\nNow I know the alphabet!")
}

fun main() {
    println("4. apply 사용")
    println(alphabet4())

    println("\n\n5. buildString 사용")
    println(alphabet5())
}