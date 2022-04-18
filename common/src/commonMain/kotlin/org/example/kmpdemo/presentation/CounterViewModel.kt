package org.example.kmpdemo.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import org.example.kmpdemo.domain.Counter
import org.example.kmpdemo.usecase.DecrementCounter
import org.example.kmpdemo.usecase.GetCounter
import org.example.kmpdemo.usecase.IncrementCounter

class CounterViewModel(
    private val getCounter: GetCounter,
    private val incrementCounter: IncrementCounter,
    private val decrementCounter: DecrementCounter
) {

    /**
     * Increments the counter
     */
    fun incrementCounterLaunch() {
        CoroutineScope(Dispatchers.Default).launch {
            incrementCounter()
        }
    }

    /**
     * Decrements the counter
     */
    fun decrementCounterLaunch() {
        CoroutineScope(Dispatchers.Default).launch {
            decrementCounter()
        }
    }

    /**
     * Retrieves the counter flow
     */
    fun getCounterFlow(): Flow<Counter> {
        return getCounter()
    }
}