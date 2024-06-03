package com.example.atry.data.createRepo

import com.example.atry.data.model.UserInfo
import com.example.atry.util.UiState
import kotlinx.coroutines.flow.Flow


interface UserRepo{

     fun Register(user:UserInfo): Flow<UiState<String>>
    suspend fun isExit(email:String):Boolean

}