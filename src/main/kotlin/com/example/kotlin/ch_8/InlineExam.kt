package com.example.kotlin.ch_8

import java.io.BufferedReader
import java.io.FileReader

fun main() {

}

/**
 * java에서는 closeable을 구현한 클레스는 try-resource-with 구문으로 자동 반환이 된다.
 * 코틀린에서는 closeable의 확장함수로 use를 지원하는데, 해당 확장함수는 람다를 인자로 받는다.
 * 해당 람다를 수행한후 자원을 자동으로 반납한다. 물론 람다중 에러가 발생해도 자원을 반납해준다.
 */
fun readFirstLineFromFile(path: String) = BufferedReader(FileReader(path)).use { it.readLine() }