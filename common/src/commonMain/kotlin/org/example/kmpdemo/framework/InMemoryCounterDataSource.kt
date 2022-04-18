package org.example.kmpdemo.framework

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import org.example.kmpdemo.data.CounterDataSource
import org.example.kmpdemo.domain.Counter

/**
 * In-memory basic implementation of [CounterDataSource]
 */
class InMemoryCounterDataSource(
    private var counter: Counter = Counter(),
    private var counterFlow: MutableSharedFlow<Counter> = MutableSharedFlow(
        extraBufferCapacity=2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
): CounterDataSource {


    override suspend fun increment() {
        counter = counter.copy(
            value = counter.value+1,
            message = "increment"
        )
        counterFlow.tryEmit(counter)
    }

    override suspend fun decrement() {
        counter = counter.copy(
            value = counter.value-1,
            message = "decrement"
        )
        counterFlow.tryEmit(counter)
    }

    override fun getCounterFlow(): Flow<Counter> {
        return counterFlow.asSharedFlow()
    }
}