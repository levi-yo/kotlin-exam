package com.example.kotlin.ch_2

fun main() {
    helloWorld()
    println(max(1,2))
    println(max2(1, 2 ))
}

/**
 * 리턴이 없는 함수
 */
fun helloWorld() {
    println("hello, world")
}

/**
 * 리턴값이 있는 함수
 */
fun max(a: Int, b: Int): Int {
    //코틀린의 if문은 식(리턴 값이 존재)이지 문(block, return이 없음)이 아니다.
    return if (a > b) a else b
}

/**
 * max 함수와 간략 버전
 * 함수의 본문이 식으로만 이루어져있다면, 아래처럼 간략하게 바꿀 수 있다.
 * 또한 반환 타입도 생략이 가능하다.
 * fun max2(a: Int, b: Int): Int = if (a > b) a else b
 * ->
 * fun max2(a: Int, b: Int) = if (a > b) a else b
 */
fun max2(a: Int, b: Int) = if (a > b) a else b