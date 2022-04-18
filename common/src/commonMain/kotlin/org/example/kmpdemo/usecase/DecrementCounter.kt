package org.example.kmpdemo.usecase

import org.example.kmpdemo.data.CounterRepository

/**
 * Use case for decrementing a counter
 */
class DecrementCounter(
    private val repository: CounterRepository
) {
    suspend operator fun invoke() {
        repository.decrement()
    }
}