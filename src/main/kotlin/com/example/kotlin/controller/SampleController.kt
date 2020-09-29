package com.example.kotlin.controller

import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(val service: SampleService) {
    @GetMapping("/")
    suspend fun index(): SampleEntity {
        return service.findEntity()
    }
}

@Service
class SampleService(val repository: SampleRepository) {
    suspend fun findEntity(): SampleEntity {
        println("current thread name = ${Thread.currentThread().name}")
        return repository.findSample()
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