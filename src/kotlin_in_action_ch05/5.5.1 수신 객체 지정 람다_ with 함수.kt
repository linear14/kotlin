package kotlin_in_action_ch05

// 일반적인 방법
// 같은 result를 너무 여러 번 사용. 코드가 길어지면 알아보기 힘들 수 있음
fun alphabet(): String {
    val result = StringBuilder()
    for(letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

// with을 사용하여 수신객체를 지정
// this.append 처럼 this를 사용해서 수신객체를 표기해줘도 괜찮지만,
// this가 없이 사용해도 아무 문제 없음 (그냥 append 사용해도 된다는 소리)
fun alphabet2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for(letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}

// 불필요한 stringBuilder 변수까지 없애버리자 (식을 본문으로 하는 함수 활용)
fun alphabet3() = with(StringBuilder()){
    for(letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun main() {
    println("1. 일반적인 방법")
    println(alphabet())

    println("\n2. with을 사용하는 방법")
    println(alphabet2())

    println("\n3. 식을 본문으로 하는 함수 활용")
    println(alphabet3())
}