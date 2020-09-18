package com.example.kotlin.ch_2

//String
val question = "sample question"
//Int
val num = 42
val answer: Int = 42

//Double
val yearsToCompute = 7.5e6

//변경, 재할당이 가능한 변수
//한번 타입이 추론되면 다른 곳에서 어싸인할때 다른 타입으로 못넣음.
var variable = 1

/**
 * val 키워드지만, 컴파일러가 오직 하나의 초기화 문장만
 * 실행됨이 확실하면 여러 곳에서 할당하는 코드가 들어갈 수 있다.
 * (자바는 final로 선언하면 반드시 초기화 코드가 들어가야하고 다른 곳에서 어싸인이 안됨)
 */
fun variableExam(b: Boolean): String {
    val message: String

    if (b) {
        message = "true"
    } else {
        message = "false"
    }

    return message
}