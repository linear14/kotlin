package kotlin_in_action_ch05

fun main() {
    val list = listOf(1, 2, 3, 4)
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // filter 함수와 map 함수는 새로운 리스트를 반환한다.
    println("1. filter 함수 사용법")
    println(list.filter{ it % 2 == 0 })
    println(people.filter{ it.age > 30 })

    println("\n\n2. map 함수 사용법")
    println(list.map{ it * it })
    println(list.map{ it % 2 == 0 }) // boolean 리스트를 반환

    // 새로운 리스트를 반환한다는 것을 보여주기 위해 작성
    val newList = list.map{ it * it }
    println(newList)
    println(people.map(Person::name))

    println("\n\n3. 가장 나이 많은 사람의 이름을 알고싶다. 최대한 효율적으로.")
    val maxAge = people.maxBy(Person::age)!!.age
    println(people.filter{ it.age == maxAge }.map(Person::name))

    // 아래의 코드는 비효율적이다. 왜냐하면 filter가 돌면서 계속해서 maxBy 함수를 돌리기 때문이다.
    // people.filter{ it.age == people.maxBy(Person::age)!!.age }.map(Person::name)

    println("\n\n4. 필터와 변환 함수를 Collection의 Map에 적용시키기")
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })
}