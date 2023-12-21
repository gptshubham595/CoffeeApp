package com.example.utils

object Utils {

    sealed class Either<out L, out R> {
        data class Error<out L>(val exception: L) : Either<L, Nothing>()
        data class Success<out R>(val data: R) : Either<Nothing, R>()
    }
}