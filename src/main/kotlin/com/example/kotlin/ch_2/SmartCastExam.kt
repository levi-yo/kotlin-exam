package com.example.kotlin.ch_2

import java.lang.IllegalArgumentException

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        if (e is Num) {
            val num = e as Num
            num.value
        } else if (e is Sum) {
            eval(e.left) + eval(e.right)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }


fun eval2(e: Expr): Int =
        when (e) {
            is Num -> {
                println("value : ${e.value}")
                e.value
            }
            is Sum -> {
                println("sum : ${e.left} + ${e.right}")
                eval2(e.left) + eval2(e.right)
            }
            else -> {
                throw IllegalArgumentException("Unknown expression")
            }
        }

fun main() {
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
}
