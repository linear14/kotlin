package kotlin_in_action_ch06

fun main() {
    
    // 1. 타입 파라미터 T는 ?가 명시되어 있지 않아도 nullable한 값이다. (Any?)
    // 따라서, 그 변수를 사용하고 싶으면 아래와 같이 ?. 등을 통해 null 처리를 해줘야 함
    fun <T> printHashCode(t: T) {
        println(t?.hashCode())
    }
    printHashCode(null)


    // 2. 만약 null이 될 수 없는 타입 파라미터만으로 제한 하려면?
    fun <T: Any> printHastCodeAny(t: T) {
        println(t.hashCode())
    }
    // printHashCode(null) --> 컴파일 에러
}