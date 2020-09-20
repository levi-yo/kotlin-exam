package com.example.kotlin.ch_6

import org.springframework.util.Assert

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private lateinit var myService: MyService

//    @Before
//    fun setUp() {
//        myService = MyService()
//    }
//
//    @Test
//    fun testAction() {
//        Assert.assertEquals("foo", myService.performAction())
//    }
}

fun main() {
    val person: Person? = null
    //person은 널이 될 수 있는 타입이라 let 함수를 바로 호출하고 내부 람다에서 바로 수신객체를 사용하면 컴파일 에러가 난다.
//    person.let { it.name }
    person?.let { it.name }

    val str: String? = null
    str.isNullOrBlank()
}

//fun <T> printObject(t: T) {
//    println(t?.toString())
//}

fun <T: Any> printObject(t: T) {
    println(t.toString())
}