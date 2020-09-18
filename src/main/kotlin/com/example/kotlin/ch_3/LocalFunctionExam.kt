package com.example.kotlin.ch_3

import java.lang.IllegalArgumentException

class UserNotRefactoring(val id: Long, val name: String, val address: String) {
    fun saveUser(user: UserNotRefactoring) {
        if (user.name.isEmpty()) {
            throw IllegalArgumentException("empty user name")
        }

        if (user.address.isEmpty()) {
            throw IllegalArgumentException("empty user address")
        }

        // user를 데이터베이스에 저장하는 로직.
    }
}

class UserWithLocalFunction(val id: Long, val name: String, val address: String) {
    fun saveUser(user: UserWithLocalFunction) {
        fun validate(user: UserWithLocalFunction, value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("empty ${user.id} $fieldName")
            }
        }

        validate(user, user.name, "name")
        validate(user, user.address, "address")

        // user를 데이터베이스에 저장하는 로직.
    }
}

class UserWithLocalFunctionAndClosure(val id: Long, val name: String, val address: String) {
    fun saveUser(user: UserWithLocalFunctionAndClosure) {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("empty ${user.id} $fieldName")
            }
        }

        validate(user.name, "name")
        validate(user.address, "address")
        val user = User(1, "", "")
        // user를 데이터베이스에 저장하는 로직.
    }
}

class User(val id: Long, val name: String, val address: String) {
    fun User.validate() {
        fun validateParam(value: String, fieldName: String) {
            fun validate(value: String, fieldName: String) {
                if (value.isEmpty()) {
                    throw IllegalArgumentException("empty ${this.id} $fieldName")
                }
            }
        }
        validateParam(this.name, "name")
        validateParam(this.address, "address")
    }
    fun saveUser(user: User) {
        user.validate()
        // user를 데이터베이스에 저장하는 로직.
    }
}