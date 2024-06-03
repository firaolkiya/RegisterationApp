package com.example.atry.data.createRepo

import androidx.lifecycle.LiveData
import com.example.atry.data.model.UserInfo
import com.example.atry.util.UiState
import kotlinx.coroutines.flow.Flow

interface HomepageRepository {

       fun getAllUser():Flow<UiState<List<UserInfo>>>
}