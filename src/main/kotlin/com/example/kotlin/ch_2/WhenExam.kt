package com.example.kotlin.ch_2

fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "GOOD"
    Color.ORANGE -> "NOT BAD"
    Color.GREEN, Color.YELLOW -> "BAD"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.ORANGE) -> "first"
    setOf(Color.YELLOW, Color.GREEN) -> "second"
    else -> throw Exception("exception")
}

fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == Color.RED && c2 == Color.YELLOW) -> "first"
    (c1 == Color.YELLOW && c2 == Color.GREEN) -> "second"
    else -> throw Exception("exception")
}

fun main(args: Array<String>) {

}