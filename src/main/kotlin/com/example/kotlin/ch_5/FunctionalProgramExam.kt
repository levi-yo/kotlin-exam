package com.example.kotlin.ch_5

import reactor.core.publisher.Mono

data class Person(val name: String, val age: Int)

fun main() {
    val personList = listOf(Person("levi", 29), Person("sora", 31), Person("boram", 29))
    println(personList.maxBy({p: Person -> p.age}))
    println(personList.maxBy() { p: Person -> p.age})
    println(personList.maxBy { p -> p.age })
    println(personList.maxBy { it.age })
    println(personList.maxBy (Person::age))
    personList.forEach {
        println(it.name)
    }

    println(personList.joinToString(" ", transform = {p: Person -> p.name}))
    println(personList.joinToString(" ", transform = {p -> p.name}))
    println(personList.joinToString(" ", transform = {it.name}))
    println(personList.joinToString(" "){p: Person -> p.name})

    val multiple = {x: Int, y: Int ->
        println("multiple $x * $y")
        x * y
    }
    println(multiple(1, 2))

    val sum = {x: Int, y: Int -> x + y}
    // 람다를 값으로받은 sum 함수를 직접 람다처럼 실행시켜준다.
    println(sum(1, 2))
    // 람다를 실행시켜주는 run 함수
    run { -> println("lambda")}

    run(::execute)

    val p = Person("levi", 29)
    val age = p::age //Person::age

    println(age())
}

fun execute() {
    println("execute")
}
