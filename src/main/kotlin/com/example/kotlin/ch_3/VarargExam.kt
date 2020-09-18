package com.example.kotlin.ch_3

//fun <T> listOf(vararg values: T): List<T> {...}

fun main(args: Array<String>) {
    val arr = arrayOf("b", "c")
    println(listOf("abc", *arr))
}