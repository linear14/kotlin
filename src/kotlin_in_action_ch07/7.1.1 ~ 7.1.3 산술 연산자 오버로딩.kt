package kotlin_in_action_ch07

// operator 예약어를 사용하여 연산자 오버로딩
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// 이런식으로 확장함수 꼴로 만들어서 오버로딩도 가능 (확장 함수로 구현하는 것이 일반적이 패턴)
operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

// 매개변수가 꼭 같은 타입 일 필요는 없다.
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

// 단항 연산자 오버로딩도 가능. 매개변수가 필요없음
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

fun main() {
    println("=====7.1.1 이항 산술 연산자 오버로딩=====")
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    println(p1 - p2)
    println(p1 * 1.5)
    // println(1.5 * p1) 교환법칙은 성립하지 않는다. 위처럼 작동하게 만들고 싶다면 Double.times 를 재정의 해줘야한다.

    println("\n=====7.1.2 복합 대입 연산자 오버로딩=====")
    val list = arrayListOf<Int>(1, 2)
    list += 3 // list를 변경만 할 뿐 새로운 객체를 만들어 내지는 않음 (복합 대입 연산자 오버로딩 -> plusAssign)
    val newList = list + listOf(4, 5) // 새로운 list를 반환 (이항 산술 연산자 오버로딩 -> plus)
    println(list)
    println(newList)

    println("\n=====7.1.3 단항 연산자 오버로딩=====")
    println(-p1)
}