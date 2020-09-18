package com.example.kotlin.ch_4

interface SampleInterface1 {
    val property: String
    fun method1()
    fun method3() = println("method2")
}

interface SampleInterface2 {
    fun method2()
    fun method3() = println("method2")
}

class SampleImpl(): SampleInterface1, SampleInterface2 {
    override val property: String
        get() = TODO("Not yet implemented")

    override fun method1() {
        TODO("Not yet implemented")
    }

    override fun method3() {
        super<SampleInterface2>.method3()
    }

    override fun method2() {
        TODO("Not yet implemented")
    }
}

open class SampleOpen(val value: String): SampleInterface1 {
    override val property: String
        get() = TODO("Not yet implemented")

    fun disable() {}
    open fun animate() {}
    override fun method1() {
        TODO("Not yet implemented")
    }
}

class SampleOpenImpl(val key: String, value: String): SampleOpen(value) {
    override fun animate() {
        super.animate()
    }
}

internal class SampleInternal {

}

internal fun SampleInternal.expendFunction() {}

// 확장함수를 만들때, 수신객체 타입의 접근제한자보다 같거나 낮은 수준의 접근지정자가 되어야한다.

sealed class SampleSealed {
    open fun method() {}
}

class SampleSealedImpl1: SampleSealed() {
    override fun method() {
        super.method()
    }
}
class SampleSealedImpl2: SampleSealed() {
    override fun method() {
        super.method()
    }
}

class SampleSealedImpl3: SampleSealed() {
    override fun method() {
        super.method()
    }
}

fun whenExam(obj: SampleSealed) = when (obj) {
    is SampleSealedImpl1 -> println("interfaceImpl1")
    is SampleSealedImpl2 -> println("interfaceImpl2")
    is SampleSealedImpl3 -> println("interfaceImpl3")
}

interface InterfaceExam {}
class InterfaceImpl1: InterfaceExam
class InterfaceImpl2: InterfaceExam
class InterfaceImpl3: InterfaceExam

fun whenExam(obj: InterfaceExam) = when (obj) {
    is InterfaceImpl1 -> println("interfaceImpl1")
    is InterfaceImpl2 -> println("interfaceImpl2")
    is InterfaceImpl3 -> println("interfaceImpl3")
    else -> println("els")
}


class User1(val name: String)

class User2 constructor(name: String){
    val name: String
    init {
        this.name = name
    }
}

class User3(name: String){
    val name: String = name
}

open class User(val name: String)
class TwitterUser(name: String): User(name)

class Secretive private constructor() {}

open class View {
    constructor(title: String): this(title, "")
    constructor(title: String, content: String) {}
}

class MyButton: View {
    constructor(title: String): super(title){

    }

    constructor(title: String, content: String): super(title, content) {

    }
}

interface Book {
    val name: String
}

class EBook1(override val name: String): Book
class EBook2: Book {
    override val name: String
        get() = TODO("Not yet implemented")
}
class EBook3(val category: String): Book {
    override val name = getBookName(category)
    private fun getBookName(category: String) = "ebook"
}

data class BookDto(val name: String, val price: Int) {}

/**
 * 자바와 달리 데코레이터 패턴을 아주 쉽게 구현할 수 있다.
 * 보통 특정 클래스를 상속할때 상위 클래스의 기능이 변경되면, 하위 클래스의 동작에도 문제가 생기는데
 * 아래처럼 위임 관계를 만들어주면 실제 상위 클래스의 구현에 의존하지 않고, 위임하기때문에 상위클래스 변경에
 * 안전하다.
 */
class DelegatingCollection<T>(
        private val innerList: Collection<T> = ArrayList<T>()
): Collection<T> by innerList {

}

class BookNamePriceMap(
        private val map: Map<String, Int> = hashMapOf()
): Map<String, Int> by map {

}

object Payroll {
    const val companyName = "company"
    init {
    }
}

/**
 * 클래스 안에 객체가 선언되면, 그 내부 객체 선언은 바깥의 클래스의 private 멤버 접근이 가능하다.
 */
class OuterClass private constructor(val name: String) {
    private fun method() = println("private method")
    //내부 객체선언이 일반 객체선언이라면, 내부 객체 선언의 private 멤버 혹은 함수 접근이 안된다.
//    private fun method2() = OuterClassFactory.method()
    object OuterClassFactory {
        fun newOuterClass() = OuterClass("outerName")
        private fun method() = println("")
    }
}

class OuterClass2 private constructor(val name: String) {
    //내부 객체선언이 동반 객체선언이라면, 내부 객체 선언의 private 멤버 혹은 함수 접근이 가능하다.
    private fun method2() = method()
    private fun method3() = value

    companion object OuterClassFactory {
        private const val value = ""

        fun newOuterClass() = OuterClass2("outerName")

        private fun method() = println("")

        fun companionMethod() = println("")
    }
}

fun main2() {
//    val outer1 = OuterClass.newOuterClass()
    //OuterClass2의 동반객체의 메서드를 마치 자신의 메서드처럼 호출가능하다.
    val outer2 = OuterClass2.newOuterClass()
    OuterClass2.companionMethod()
}

class LazyClass {
    companion object LazyClassUtils {
        fun method() {
            val value = { -> {
                println("lambda value block")
                "lambda value"
            }.invoke()}
            println("before lambda")
            println(value.invoke())
        }
    }
}

fun main() {
//    when (SampleSealedImpl()) {
//        is SampleSealedImpl -> println()
//    }
    LazyClass.method()
}