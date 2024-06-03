package com.example.atry.Presentation.CreateAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atry.data.createRepo.UserRepo
import com.example.atry.data.model.UserInfo
import com.example.atry.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    val userRepo: UserRepo
): ViewModel() {

    val _isAdded = MutableStateFlow<UiState<String>>(UiState.Loading)
    val isAdded: Flow<UiState<String>> = _isAdded
    fun addUser(
        name: String,
        father: String,
        email: String,
        password: String
    ) {
        val user = UserInfo(
            name = name,
            father = father,
            email = email,
            password = password
        )
        viewModelScope.launch {
            userRepo.Register(user).collect { uiState ->
                _isAdded.value = uiState
            }
        }

    }
}