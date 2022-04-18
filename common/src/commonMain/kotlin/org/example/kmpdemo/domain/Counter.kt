package org.example.kmpdemo.domain

/**
 * Model for the number counter
 * @param value The counter value
 * @param message Additional context attached to the counter
 */
data class Counter (
    val value: Int = 0,
    val message: String = "Init"
)