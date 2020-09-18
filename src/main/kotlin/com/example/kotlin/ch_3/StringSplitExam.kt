package com.example.kotlin.ch_3

fun main() {
//    val str = "12.345-6.A"
//
//    println(str.split(".", "-"))
//    println(str.split("\\.|-".toRegex()))
    val path = "/Users/levi/kotlin/chapter3.kt"
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBefore(".")
    val extension = fullName.substringAfter(".")
    println("Dir : $directory, FullName : $fullName, FileName : $fileName, Extension : $extension")
}

