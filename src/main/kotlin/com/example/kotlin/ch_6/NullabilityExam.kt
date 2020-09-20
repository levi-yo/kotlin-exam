package com.example.kotlin.ch_6

import java.lang.IllegalArgumentException

//fun strLen(string: String?) = string.length

fun strLength(str: String) = str.length

fun main1() {
//    strLength(null)
    val upperCase: String? = getUpperCase("str")
}

val x: String? = null
//val y: String = x

fun strLenSafe(s: String?): Int =
        if (s != null) s.length else 0

fun getUpperCase(s: String?) = s?.toUpperCase()

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false

        return otherPerson.name == this.name
    }
}
fun Person.countryName() = this.company?.address?.country ?: "Unknown"
fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("empty address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun sendEmailTo(email: String): String {
    println("send email to $email")
    return email
}

fun main() {
    val email: String? = null
    if (email != null) sendEmailTo(email)

    println(email?.let { sendEmailTo(it) })
}