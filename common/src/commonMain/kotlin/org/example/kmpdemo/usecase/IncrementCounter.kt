package org.example.kmpdemo.usecase

import kotlinx.coroutines.flow.Flow
import org.example.kmpdemo.data.CounterRepository

/**
 * Use case for incrementing a counter
 */
class IncrementCounter(
    private val repository: CounterRepository
) {
    suspend operator fun invoke() {
        repository.increment()
    }
}