package kotlin_in_action_ch04

interface User {
    val nickname: String
}

// 생성자로 초기화 하는 방법
class PrivateUser(override val nickname: String): User

// 내부에서 식을 사용하여 구현하는 방법
class SubscribingUser(private val email: String): User {
    override val nickname = email.substringBefore("@")
}

// custom getter를 이용하는 방법
class FacebookUser(val accountId: Int): User {
    override val nickname: String
        get() = "Nick${accountId}".substring(0..8)
}