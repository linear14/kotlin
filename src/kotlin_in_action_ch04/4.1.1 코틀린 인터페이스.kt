package kotlin_in_action_ch04

interface Clickable {
    fun click()

    // 아래와 같이 인터페이스 안에 구체화된 함수를 정의할 수 있다.
    fun showOff() = println("I am clickable")
}

interface Focusable {
    fun showOff() = println("I am focusable")
}

class Button: Clickable {
    override fun click() = println("I was clicked")
}

class Button2: Clickable, Focusable {
    override fun click() = println("I was clicked")

    // 구현 할 두개의 인터페이스에 같은 이름을 가진 디폴트 함수가 있다면? -> 구현을 해야한다.
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
fun main() {
    println("1번 예제")
    Button().click()
    Button().showOff()

    println("\n2번 예제")
    Button2().showOff()
}