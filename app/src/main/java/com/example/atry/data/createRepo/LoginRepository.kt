package com.example.atry.data.createRepo

import com.example.atry.data.model.UserInfo
import dagger.hilt.android.HiltAndroidApp

interface LoginRepository {

    suspend fun getUserByEmail(email:String):UserInfo;
}