package com.example.kotlin.ch_5

import reactor.core.publisher.Mono

data class Person(val name: String, val age: Int)

fun main1() {
    val personList = listOf(Person("levi", 29), Person("sora", 31), Person("boram", 29))
    println(personList.maxBy({p: Person -> p.age}))
    println(personList.maxBy { p: Person -> p.age})
    println(personList.maxBy { p -> p.age })
    println(personList.maxBy { it.age })
    println(personList.maxBy (Person::age))
    personList.forEach {
        println(it.name)
    }

    println(personList.joinToString(" ", transform = {p: Person -> p.name}))
    println(personList.joinToString(" ", transform = {p -> p.name}))
    println(personList.joinToString(" ", transform = {it.name}))
    //함수의 마지막 인자가 람다라면, 괄호 밖으로 꺼내서 정의할 수 있다.
    println(personList.joinToString(" "){p: Person -> p.name})

    val multiple = {x: Int, y: Int ->
        println("multiple $x * $y")
        x * y
    }
    println(multiple(1, 2))

    //변수에 담을때는 타입 추론이 안되, 인자의 타입을 명시
    val sum = {x: Int, y: Int -> x + y}
    // 람다를 값으로받은 sum 함수를 직접 람다처럼 실행시켜준다.
    println(sum(1, 2))
    // 람다를 실행시켜주는 run 함수
    run { -> println("lambda")}
    //에타변환: 함수 f와 람다 ( x -> f(x) )를 서로 바꿔쓰는 것
    run(::execute)

    val p = Person("levi", 29)
    //바운드 멤버 참조
    val age = p::age //Person::age

    println(age())
}

fun execute() {
    println("execute")
}

fun main2() {
    val list = listOf(1, 2, 3)
    println(list.maxBy { it })
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })
    println(list.filter { it % 2 == 0 }.map { it * it })

    println("============map============")

    val map = mapOf(1 to "one", 2 to "two")
    //key로 필터한다.
    println(map.filterKeys { it % 2 == 0 })
    //key값을 변경해준다.
    println(map.mapKeys { entry -> entry.key * 2})

    //value를 필터한다.
    println(map.filterValues { it == "two" })
    //value를 변경해준다.
    println(map.mapValues { entry -> entry.value + "- ${entry.key}"})

    println("============all, any, count, find============")

    val people = listOf(Person("levi", 29), Person("sora", 31))

    //컬렉션의 모든 요소가 람다를 만족하는가
    val all: Boolean = people.all { it.age > 30 }
    println(all)
    //컬렉션의 일부 원소가 람다를 만족하는가
    val any: Boolean = people.any { it.age > 30}
    println(any)
    //조건을 만족하는 원소의 개수
    val count:Int = people.count { it.age > 30}
    println(count)

    //특정 조건으로 그룹화
    val intListMap: Map<Int, List<Person>> = people.groupBy { it.age }
    println(intListMap)
}

fun main() {
    val people = listOf(Person("levi", 29), Person("sora", 31))
    /**
     * 코틀린의 map과 filter 연산은 반환값으로 List를 반환한다. 그 말은
     * 기존의 list말고 또하나의 list를 생성한다는 뜻이다.
     */
    val nameList = people.asSequence()
            .map {
                println(it.name)
                it
            }
            .map { it.name } //최종연산 전까지는 지연연산되어 실제 계산되지 않는다.
            .toList()

    //자바 함수형 인터페이스에 대해 람다로 함수형 인터페이스 무명 인스턴스를 만들 수 있다.
    val executable = Runnable { println("executable") }
}