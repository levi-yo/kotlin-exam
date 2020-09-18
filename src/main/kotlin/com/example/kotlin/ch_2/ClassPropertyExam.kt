package com.example.kotlin.ch_2

/**
 * Kotlin class definition
 */
class Person(val name: String,
             var age: Int) {
    val isProgrammer: Boolean
        get() = name == "levi"
}

fun main(args: Array<String>) {
    val person = Person("levi", 29)
    println(person.name)
    println(person.age)
    person.age = 30

    println(person.isProgrammer)
}

