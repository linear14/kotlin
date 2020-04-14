package kotlin_in_action_ch05

fun main() {
    val canBeInClub27 = { p: Person -> p.age <= 27 }
    val people = listOf(Person("Alice", 29), Person("Bob", 25))
    println("1. all 함수")
    println(people.all(canBeInClub27))

    println("\n\n2. any 함수")
    println(people.any(canBeInClub27))

    println("\n\n3. count 함수")
    println(people.count(canBeInClub27))

    println("\n\n4. find 함수") // firstOrNull 함수와 같음
    println(people.find(canBeInClub27))
    println(people.firstOrNull(canBeInClub27))
}