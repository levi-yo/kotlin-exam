package com.example.kotlin.ch_8

fun sum(x: Int, y: Int, function: (Int, Int) -> Int): Int {
    println("$x + $y")
    return function(x,y)
}
fun sum2(x: Int, y: Int, function: (Int, Int) -> Int): Int {
    println("$x + $y")
    return run {function(x,y)}
}

fun main2() {
    println("before")
    sum(1,2) { x, y -> x + y}
    println("after")

    println("before")
    sum2(1,2) { x, y -> x + y}
    println("after")
}

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        transform: (T) -> String = {t -> t.toString()}): String = ""

fun foo(callback: (() -> String)?) = callback?.invoke() ?: "Unknown"

fun main() {
    println(foo(null))
    println(foo {"hi"})
}