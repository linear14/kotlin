package kotlin_in_action_ch06

// 안전한 캐스팅 as? 를 이용한 뒤, 만약 null 값이라면 false를 반환하도록 elvis operator와 함께 사용 해 주는 것이 좋음
fun main() {
    class Person(val firstName: String, val lastName: String) {
        override fun equals(other: Any?): Boolean {
            val otherPerson = other as? Person ?: return false
            return otherPerson.firstName == firstName && otherPerson.lastName == lastName
        }

        override fun hashCode(): Int =
            firstName.hashCode() * 37 + lastName.hashCode()
    }

    val p1 = Person("Alice", "Pop")
    val p2 = Person("Alice", "Pop")
    println(p1 == p2)
    println(p1.equals(54))
}