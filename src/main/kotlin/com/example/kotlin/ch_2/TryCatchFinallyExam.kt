package com.example.kotlin.ch_2

import java.io.BufferedReader
import java.lang.NumberFormatException

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine() //checked exception이 발생
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}

fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}