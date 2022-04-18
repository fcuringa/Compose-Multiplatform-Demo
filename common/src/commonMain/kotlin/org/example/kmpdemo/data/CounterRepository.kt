package org.example.kmpdemo.data

import kotlinx.coroutines.flow.Flow
import org.example.kmpdemo.domain.Counter

/**
 * Repository for [Counter]
 */
class CounterRepository(
    private val counterDataSource: CounterDataSource
) {

    suspend fun increment() {
        counterDataSource.increment()
    }
    suspend fun decrement() {
        counterDataSource.decrement()
    }
    fun getCounterFlow(): Flow<Counter> {
        return counterDataSource.getCounterFlow()
    }
}