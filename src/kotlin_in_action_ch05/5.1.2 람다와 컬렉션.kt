package kotlin_in_action_ch05

data class Person(val name: String, val age: Int)

// 컬렉션의 직접 탐색
fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for(person in people) {
        if(person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println(theOldest)
}

fun main() {
    println("1. 컬렉션의 직접 탐색")
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    println("\n\n2. 람다를 사용한 컬렉션 탐색")
    println(people.minBy{it.age})

    println("\n\n3. 멤버 참조를 사용한 컬렉션 검색")
    println(people.maxBy(Person::age))
}