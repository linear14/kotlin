package kotlin_in_action_ch06

// 매개변수를 non-null 로 받는 함수에, nullable 인자를 넣을 수 없음.
// 이를 해결해주기 위한 방법으로 let 함수 도입
// let함수는 사용할 수신 객체의 null 가능성을 보고, 만약 null이면 이후의 람다식을 실행하지 않음

fun main() {
    // String 매개변수를 받아야 함 (non-null)
    fun sendEmailTo(email: String) {
        println("Sending Email to $email")
    }

    val emailNull: String? = null
    val emailNonNull: String? = "linear14@naver.com"

    // 이렇게 꼭 수신객체에 ? 를 붙여서 null 이 아닐 수 있다는 가능성을 줘야 됨
    // 만약 ?를 안붙이면.. 무조건 null로 인식해서 컴파일 에러 (람다식을 실행 할 수 없어서)
    emailNull?.let { sendEmailTo(it) }      // 아무일도 생기지 않음. (람다식에 접근x)
    emailNonNull?.let { sendEmailTo(it) }
}