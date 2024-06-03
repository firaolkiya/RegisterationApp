package com.example.atry.Presentation.Login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atry.data.createRepo.LoginRepository
import com.example.atry.data.createRepo.UserRepo
import com.example.atry.data.model.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginRepository: LoginRepository,
):ViewModel() {

    fun addUser(){

    }

}