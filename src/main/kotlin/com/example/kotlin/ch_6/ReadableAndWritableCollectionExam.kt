package com.example.kotlin.ch_6

class CollectionDeco<T>(private val innerList: Collection<T> = ArrayList()): Collection<T> by innerList {}
class MutableCollectionDeco<T>(private val innerList: MutableCollection<T> = ArrayList()): MutableCollection<T> by innerList {}