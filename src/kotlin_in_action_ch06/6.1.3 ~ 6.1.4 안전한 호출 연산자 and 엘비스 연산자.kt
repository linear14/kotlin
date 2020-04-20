package kotlin_in_action_ch06

import java.lang.IllegalArgumentException

// ?. 연산자를 사용한다.
// 호출하는 값이 null 이면 null반환, 아니면 일반 메서드 사용처럼 . 뒤의 내용이 실행

fun main() {
    // 1. 기본적인 ?. 사용법
    fun printAllCaps(s: String?) {
        val allCaps: String? = s?.toUpperCase()
        println(allCaps)
    }
    println("=====1. 기본적인 ?. 사용법=====")
    printAllCaps(null)
    printAllCaps("abc")

    // 2. 널이 될 수 있는 프로퍼티를 다루기 위해 안전한 호출 사용하기
    println("\n=====2. 응용=====")
    class Employee(val name: String, val manager: Employee?) {
        fun manageName(employee: Employee): String? = employee.manager?.name
    }
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(developer.manageName(ceo))

    // 3. 안전한 호출의 연쇄
    println("\n=====3. 호출 연쇄=====")
    class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
    class Company(val name: String, val address: Address?)
    class Person(val name: String, val company: Company?)
    fun Person.countryName(): String {
        val country = this.company?.address?.country
        return country ?: "UnKnown"     // 엘비스 연산자는 덤^^
    }

    val person = Person("Dmitry", null)
    println(person.countryName())

    // 4. 엘비스 연산자 기본 사용
    // s가 null이면 0을 반환. 아니면 s.length 반환
    println("\n=====4. 엘비스 연산자=====")
    fun strLenSafe(s: String?): Int = s?.length ?: 0
    println(strLenSafe(null))
    println(strLenSafe("abc"))

    // 5. throw와 return도 코틀린에서는 식이다.
    println("\n=====5. throw와 엘비스 연산자 함께 사용하기=====")
    fun printShippingLabel(person: Person) {
        val address = person.company?.address ?: throw IllegalArgumentException("No Address")
        with(address) {
            println(streetAddress)
            println("$zipCode $city, $country")
        }
    }
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person2 = Person("Dmitry", jetbrains)
    printShippingLabel(person2)
    printShippingLabel(Person("Alex", null))

}