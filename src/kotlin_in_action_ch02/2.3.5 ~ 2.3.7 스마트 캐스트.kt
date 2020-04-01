package kotlin_in_action_ch02

import java.lang.IllegalArgumentException

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr


/*
// if 문 사용
fun eval(e: Expr): Int =
    if(e is Num) {
        e.value
    } else if(e is Sum) {
        eval(e.left) + eval(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
*/

/*
// when 문 사용
fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }
*/


// 분기에서 블록을 사용
fun eval(e: Expr): Int =
    when(e) {
        is Num -> {
            println("num : ${e.value}")
            e.value
        }
        is Sum -> {
            val left = eval(e.left)
            val right = eval(e.right)
            println("sum : $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }


fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(5))))
}