package com.example.kotlin.concurrent

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main1(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val name = getName()
        val lastName = getLastName()
        println("Hello, $name $lastName")
    }
    println("Execution took $time ms")
}

fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val name = async { getName() }
        val lastName = async { getLastName() }
        println("Hello, ${name.await()} ${lastName.await()}")
    }
    println("Execution took $time ms")
}

suspend fun getName(): String {
    delay(1000)
    return "susan"
}

suspend fun getLastName(): String {
    delay(1000)
    return "Calvin"
}