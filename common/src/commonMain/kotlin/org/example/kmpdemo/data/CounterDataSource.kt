package org.example.kmpdemo.data

import kotlinx.coroutines.flow.Flow
import org.example.kmpdemo.domain.Counter

/**
 * Data source for [Counter]
 */
interface CounterDataSource {
    /**
     * Increment the counter by 1
     */
    suspend fun increment(): Unit

    /**
     * Decrement the counter by 1
     */
    suspend fun decrement(): Unit

    /**
     * Get the counter value Flow
     */
    fun getCounterFlow(): Flow<Counter>
}