package com.example.kotlin.ch_2

fun forEach() {
    val list = listOf("a", "b", "c")

    for (str in list) {
        println(str)
    }
}

fun forEach2() {
    //range 1부터 10까지 포함
    val oneToTen = 1..10

    for (i in oneToTen) {
        println(i)
    }
}

fun forEach3() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

fun forEach4() {
    val lowerUpperCaseMap = HashMap<Char, Char>()

    for (c in 'A'..'F') {
        val lowerCase = c.toLowerCase()
        //자바의 map.put(lowerCase, c)와 같다.
        lowerUpperCaseMap[lowerCase] = c
    }

    for ((lower, upper) in lowerUpperCaseMap) {
        println("$lower $upper")
    }
}

fun main() {
//    forEach()
//    println("===============")
//    forEach2()
//    println("===============")
//    forEach3()
    forEach4()
}