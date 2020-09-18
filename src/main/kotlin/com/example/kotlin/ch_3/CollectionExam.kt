package com.example.kotlin.ch_3

import java.lang.StringBuilder

fun createHashSet() = hashSetOf(1, 7, 53)

fun createArrayList() = arrayListOf(1, 7, 53)

fun createHashMap() = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun collectionOperate() {
    val list = listOf("one", "two", "three")
    //리스트의 마지막 원소를 가져온다.
    println(list.last())

    val numbers = setOf(1, 14, 2)
    //숫자로 이루어진 컬렉션(Set)에서 가장 큰 값을 가져온다.
    println(numbers.max())
}

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, elem) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(elem)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> defaultParamValue(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, elem) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(elem)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3)
    //사실 파라미터가 뜻하는 바를 정확히 알 수 없다.
//    println(joinToString(list, ";", "(", ")"))
    //파라미터 전부 혹은 일부에 이름을 명시할 수 있다.
    //자바로 작성한 코드는 아래 기능을 사용하기 힘들다.
//    joinToString(list, separator = ";", prefix = "(", postfix = ")")

//    println(defaultParamValue(list))
    println(defaultParamValue(list, postfix = "#", prefix = ";"))
}