package com.esports.haatbazar.core

sealed class DataState<T>(
    val message: String? = null,
    val Data: T? = null,
    ) {
        class Loading<T>: DataState<T>()

        class Success<T>(data: T?): DataState<T>(null, data)

        class Error<T>(message: String?): DataState<T>(message, null)
}