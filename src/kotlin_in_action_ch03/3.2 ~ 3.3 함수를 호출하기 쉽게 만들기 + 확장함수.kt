package kotlin_in_action_ch03

// joinToString() 함수의 초기 구현 (1번, 2번)
fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) {
            result.append("$separator ")
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 디폴트 파라미터 설정 (3번)
@JvmOverloads
fun <T> joinToString2(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) {
            result.append("$separator ")
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 확장 함수 만들기 (4번)
// this를 이용하여 수신 객체 호출. (this는 생략이 가능하다)
// 또한, get과 같이,, 수신 객체 타입에 지정되어있는 함수를 이용가능하다. (다른 확장함수도 이용 가능)
fun String.lastChar(): Char = this.get(this.length - 1)

// 확장 함수로 joinToString 함수 만들기 (5번)
fun <T> Collection<T>.joinToString3(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()) {
        if(index > 0) result.append("$separator ")
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3, 4)

    // 초기 구현에 대한 사용법
    println("=====1.초기구현=====")
    println(joinToString(list, ";", "(", ")"))

    // 인자에 이름을 붙여 사용
    println("\n=====2.이름 붙인 인자=====")
    println(joinToString(list, separator = ";", prefix = "(", postfix = ")"))

    // 디폴트 파라미터
    println("\n=====3.디폴트 파라미터=====")
    println(joinToString2(list))
    println(joinToString2(list, "|"))

    // 확장 함수 기본
    println("\n=====4.확장 함수 기본=====")
    println("Kotlin".lastChar())

    // 확장 함수를 이용한 joinToString
    println("\n=====5.확장 함수 응용=====")
    println(list.joinToString3(prefix = "@", postfix = "@"))
}