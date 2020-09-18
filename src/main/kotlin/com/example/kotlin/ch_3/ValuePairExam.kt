package com.example.kotlin.ch_3

fun pair() {
    val pair = 1.to("one")
    println(pair)
}

fun main() {
    pair()
    1 pair "one"
}

infix fun Int.pair(v: String): Pair<Int, String> {
    return Pair(this, v)
}