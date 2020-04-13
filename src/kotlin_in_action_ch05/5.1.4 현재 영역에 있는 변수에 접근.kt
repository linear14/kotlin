package kotlin_in_action_ch05

fun main() {
    // 함수내의 람다식에서 파라미터값, 함수내의 지역 변수를 사용할 수 있음

    // 1. 파라미터를 사용
    fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
        messages.forEach{
            println("$prefix $it")
        }
    }

    // 2. 지역변수를 사용
    fun printProblemCounts(responses: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0
        responses.forEach {
            if(it.startsWith("4")) clientErrors++
            else if(it.startsWith("5")) serverErrors++
        }

        println("$clientErrors client errors, $serverErrors server errors occur")
    }


    val errors = listOf("403 Forbidden", "404 Not Found", "500 Internal Server Error")
    println("1. 파라미터")
    printMessageWithPrefix(errors, "Error: ")
    println("\n\n2. 지역변수")
    printProblemCounts(errors)

}