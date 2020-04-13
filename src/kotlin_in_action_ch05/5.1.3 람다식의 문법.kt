package kotlin_in_action_ch05

fun main() {
    println("1. 변수에 람다식 담기")
    val sum = {x: Int, y: Int -> x + y}
    println(sum(1, 2))

    println("\n\n2. run의 사용")
    run {println(42)}

    println("\n\n3. 함수의 인자로 람다를 넘기기")
    // 아래와 같이 여러 case로 사용 가능
    val people = listOf(Person("이몽룡", 29), Person("성춘향", 31))
    val names1 = people.joinToString(separator = " ", transform = { p: Person -> p.name })
    val names2 = people.joinToString(separator = " ", transform = { p -> p.name })
    val names3 = people.joinToString(" "){ p -> p.name }
    val names4 = people.joinToString(" ") { it.name }
    println(names1)

    // 람다식 내의 파라미터 타입을 명시를 안해줘도 괜찮지만 해주는 것이 좋긴 함
    // 특히 람다를 변수에 저장할 때는 파라미터 타입을 추론할 문맥이 존재하지 않으므로 타입을 항시 명시해 주어야 함.

    println("\n\n4. 본문이 여러 줄로 이루어진 경우")
    val sum2 = {x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum2(1, 2))
}