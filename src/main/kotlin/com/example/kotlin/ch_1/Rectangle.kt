package com.example.kotlin.ch_1

import java.util.*
import com.example.kotlin.ch_3.lastChar as last

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width

    fun sumHeightAndWidth() = height + width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main() {
    println("Kotlin".last())
}
