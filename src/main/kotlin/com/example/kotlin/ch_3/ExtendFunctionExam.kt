package com.example.kotlin.ch_3

import java.lang.StringBuilder

fun String.lastChar(): Char = this.get(this.length - 1)

//fun main() {
////    println("Kotlin".lastChar())
//    val list = listOf(1,2,3)
////    println(list.join2(",")) 컴파일 에러
//    println(list.join1(","))
//}

fun Collection<String>.join2(seperate: String): String {
    val result = StringBuilder()
    for ((i, elem) in this.withIndex()) {
        if (i > 0) result.append(seperate)
        result.append(elem)
    }
    return result.toString()
}

fun <T> Collection<T>.join1(seperate: String): String {
    val result = StringBuilder()
    for ((i, elem) in this.withIndex()) {
        if (i > 0) result.append(seperate)
        result.append(elem)
    }
    return result.toString()
}

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() {
        println("Button clicked")
    }
}

fun View.showOff() = println("I'm a view !")
fun Button.showOff() = println("I'm a button !")

fun main() {
    val view: View = Button()
    view.click()
    view.showOff()
}