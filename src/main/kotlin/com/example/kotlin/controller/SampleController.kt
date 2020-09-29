package com.example.kotlin.controller

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(val service: SampleService) {
    @GetMapping("/")
    suspend fun index(): SampleEntity {
        println("index() current thread name = ${Thread.currentThread().name}")
        return service.findEntity()
    }

    @GetMapping("/async")
    suspend fun asyncRequest(): SampleEntity = coroutineScope {
        println("asyncRequest() current thread name = ${Thread.currentThread().name}")

        val name = async {
            service.getName()
        }
        val age = async {
            service.getAge()
        }
        SampleEntity(name.await(), age.await())
    }
}

@Service
class SampleService(val repository: SampleRepository) {
    suspend fun findEntity(): SampleEntity {
        println("findEntity() current thread name = ${Thread.currentThread().name}")
        return repository.findSample()
    }

    suspend fun getName(): String {
        println("getName() current thread name = ${Thread.currentThread().name}")
        return "sora"
    }

    suspend fun getAge(): Int {
        println("getAge() current thread name = ${Thread.currentThread().name}")
        return 31
    }
}

@Repository
class SampleRepository {
    suspend fun findSample(): SampleEntity {
        println("current thread name = ${Thread.currentThread().name}")
        return SampleEntity("levi", 29)
    }
}

data class SampleEntity(val name: String, val age: Int)