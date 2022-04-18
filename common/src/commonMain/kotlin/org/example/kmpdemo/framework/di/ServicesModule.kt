package org.example.kmpdemo.framework.di

import kotlinx.coroutines.DelicateCoroutinesApi
import org.example.kmpdemo.data.CounterDataSource
import org.example.kmpdemo.data.CounterRepository
import org.example.kmpdemo.framework.InMemoryCounterDataSource
import org.example.kmpdemo.presentation.CounterViewModel
import org.example.kmpdemo.usecase.DecrementCounter
import org.example.kmpdemo.usecase.GetCounter
import org.example.kmpdemo.usecase.IncrementCounter
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton

val injectedServices = DI {
    // data
    val counterDataSource = InMemoryCounterDataSource()
    val counterRepository = CounterRepository(counterDataSource)

    // Use cases
    val getCounter = GetCounter(counterRepository)
    val incrementCounter = IncrementCounter(counterRepository)
    val decrementCounter = DecrementCounter(counterRepository)

    // View model
    bindProvider { CounterViewModel(getCounter, incrementCounter, decrementCounter) }
}