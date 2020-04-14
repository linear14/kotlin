package kotlin_in_action_ch05

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 25), Person("Carol", 29))
    val list = listOf("a", "ab", "bc")

    println("1. groupBy의 사용법")
    println(people.groupBy { it.name.length })
    println(list.groupBy(String::first))
}