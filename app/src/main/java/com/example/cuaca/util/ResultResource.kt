package com.example.cuaca.di

sealed class ResultResource<out T>(val data: T? = null, val throwable: Throwable? = null) {
    class Success<out T>(data: T) : ResultResource<T>(data = data)
    class Loading<out T>(data: T? = null) : ResultResource<T>(data = data)
    class Error<out T>(throwable: Throwable?) : ResultResource<T>(throwable = throwable)
}