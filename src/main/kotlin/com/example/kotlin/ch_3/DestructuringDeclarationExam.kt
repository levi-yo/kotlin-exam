package com.example.kotlin.ch_3

fun main() {
    val (left, right) = Pair(1, "one")
    val list = listOf(1, 2, 3)
    for ((index, value) in list.withIndex()) {}
}