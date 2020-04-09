package kotlin_in_action_ch04

// 앞서 보았던 예제
/*
interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr
fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }
*/

// 문제점: else를 사용하기가 귀찮다.
// 만약 새로운 클래스 계층을 추가할 때 처리를 해주지 않으면 else가 자동으로 사용되어 오류를 발생시킬 수 있다.

sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
    when(e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }
