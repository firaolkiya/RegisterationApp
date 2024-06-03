package com.example.atry.data.createRepo

import com.example.atry.data.model.UserInfo
import com.example.atry.util.Database
import com.example.atry.util.UiState
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepoImpl @Inject constructor(private val firestore: FirebaseFirestore) : UserRepo {
    override fun Register(user: UserInfo): Flow<UiState<String>> = flow {
        emit(UiState.Loading)
        try {
            firestore.collection(Database.tableName)
                .add(user)

                emit(UiState.Success("Registered successfully"))

        } catch (e: Exception) {
            emit(UiState.Failure("Something went wrong: ${e.message}"))
        }
    }

    override suspend fun isExit(email: String): Boolean {
        TODO("Not yet implemented")
    }
}




