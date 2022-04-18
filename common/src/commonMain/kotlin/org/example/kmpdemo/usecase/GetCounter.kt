package org.example.kmpdemo.usecase

import kotlinx.coroutines.flow.Flow
import org.example.kmpdemo.data.CounterRepository
import org.example.kmpdemo.domain.Counter

/**
 * Use case for getting a counter flow
 */
class GetCounter(
    private val repository: CounterRepository
) {
    operator fun invoke(): Flow<Counter> {
        return repository.getCounterFlow()
    }
}