package com.example.atry.util

import java.util.concurrent.Flow

sealed class  UiState<out  T> {
    object Loading:UiState<Nothing>()
    data class Success<out T>(val data:T):UiState<T>()
    data class Failure(val message:String?):UiState<Nothing>()
}