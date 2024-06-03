package com.example.atry.Presentation.Home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atry.data.createRepo.HomepageRepository
import com.example.atry.data.model.UserInfo
import com.example.atry.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    val homepageRepository: HomepageRepository
): ViewModel() {

    private val _userList = MutableStateFlow<UiState<List<UserInfo>>>(UiState.Loading)
    val userList: StateFlow<UiState<List<UserInfo>>> = _userList

    fun getAllUsers() {
        viewModelScope.launch {
            homepageRepository.getAllUser().collect { uiState ->
                _userList.value = uiState
            }
        }
    }
}