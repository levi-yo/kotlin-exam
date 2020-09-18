package com.example.kotlin.ch_1

data class Person(val name: String,
                  val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("levi"), Person("cole", age = 31))

    // == val oldest = persons.maxBy { person ->  person.age ?: 0}
    val oldest = persons.maxBy { it.age ?: 0}
    println("oldest : $oldest")

    typeCaste("string")
}

/**
 * 자바와는 다르게 타입 캐스팅 할때, 타입만 검사하면 타입 캐스팅을 자동으로 해준다.
 */
fun typeCaste(value: Any) {
    if (value is String) {
        println(value.toUpperCase())
    }
}