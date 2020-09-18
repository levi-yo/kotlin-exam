package com.example.kotlin.ch_2

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name!")
}

fun stringTemplate(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}!")
    }
}

fun stringTemplate2(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello, ${if (args.isNotEmpty()) args[0] else "Kotlin"}!")
    }
}