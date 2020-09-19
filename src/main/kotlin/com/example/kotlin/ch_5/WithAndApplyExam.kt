package com.example.kotlin.ch_5

import java.lang.StringBuilder

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I Know the alphabet!")
    return result.toString()
}

/**
 * with는 조금은 특별한 함수이다. 얼핏보기엔 인자가 1개인 함수 같지만,
 * 실제로는 인자가 2개인 함수이다.
 * 1. 수신객체
 * 2. 첫번째 받은 인자가 수신 객체인 람다
 * with는 첫번째 인자로 받은 객체를 두번째 인자로 받은 람다의 수신 객체로 만들어준다.
 */
fun alphabetUsingWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow I Know the alphabet!")
        this.toString()
    }
}

/**
 * 수신객체는 this 키워드를 뺄 수 있다.
 * 만약 해당 함수를 감싸고 있는 클래스에 수신객체와 동일한이름의
 * 함수가 있다면, this 키워드를 명시해준다.
 */
fun finalAlphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
    toString()
}

fun main() {
    println(alphabet())
    println(alphabetUsingWith())
    println(finalAlphabet())
}

/**
 * with는 람다의 마지막 식(결과)가 반환값이 되지만,
 * 람다는 람다대로 수행하고, 수신객체를 반환하고 싶을때가 있는데,
 * 그럴때는 apply를 이용한다.
 * 즉 with의 두번째 인자 람다의 반환은 특정 객체를 리턴해야하고,
 * apply의 인자인 람다의 반환은 Unit(void)이다.
 */
fun alphabetUsingApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
}.toString()

/**
 * buildString은 StringBuilder를 만들어주는 것과 toString을 호출하는것을 대신해준다.
 */
fun alphabetUsingBuildString() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I Know the alphabet!")
}