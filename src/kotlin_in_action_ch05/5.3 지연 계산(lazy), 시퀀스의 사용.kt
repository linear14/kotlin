package kotlin_in_action_ch05

// 앞서 사용했던 함수형 API 함수들은 그 함수를 만나자마자 바로 계산해버리는 특징이 있었음
// 또한, 함수가 실행된 뒤 반환값은 또 다른 LIST로 나왔기 때문에, 여러 데이터가 들어있는 경우 효율적인 면에서 불리할 수 있음
// 시퀀스는 그러한 점들을 보완.
// 새로운 LIST를 만들지 않고, 지연 계산을 통해 마지막 최종 연산 과정을 통해 한번에 값을 얻어내는 특징이 있음

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 25), Person("Carol", 29))

    println("1. 시퀀스의 사용")
    println(
    people.asSequence() // 시퀀스로 바꿔주기
        .map(Person::name)  // 시퀀스 역시 컬렉션과 같은 API를 제공
        .filter{ it.startsWith("A") }
        .toList() // 최종연산
    )

    // 시퀀스는 최종연산을 나타내는 함수가 없을 경우에 값을 출력하지 않는다.
    // 나중에 한꺼번에 연산하되, 한 원소씩 시퀀스연산을 거침을 알 수 있다.
    println("\n\n2. 시퀀스를 사용 했을 경우의 코드 실행 순서")
    println(
        listOf(1, 2, 3, 4).asSequence()
            .map{ print("map($it) "); it * it }
            .filter{ print("filter($it) "); it % 2 == 0 }
            .toList()
    )

    println("\n\n3. map -> filter 순 vs filter -> map 순")
    println("map 사용 후 filter를 사용하면?\nmap으로 모든 원소를 순회한 뒤, filter로 또 다시 모든 원소를 순회한다")
    println("filter 사용 후 map을 사용하면?\nfilter로 모든 원소를 순회한 뒤, 걸러진 친구들만 map으로 순회한다")
    println("\n결론은 filter -> map이 효율이 더 좋을 때가 많다.")
}