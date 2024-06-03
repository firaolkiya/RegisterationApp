package com.example.atry.data.createRepo

import androidx.lifecycle.LiveData
import com.example.atry.data.model.UserInfo
import com.example.atry.util.Database
import com.example.atry.util.UiState
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HomageRepoImpl @Inject constructor(
    val firestore: FirebaseFirestore
) : HomepageRepository {
    override fun getAllUser(): Flow<UiState<List<UserInfo>>> = flow {
        emit(UiState.Loading)

        try {
            val querySnapshot = firestore.collection(Database.tableName).get().await()
            val data = arrayListOf<UserInfo>()
            for (document in querySnapshot.documents) {
                val user = document.toObject<UserInfo>()
                user?.let { data.add(it) }
            }
            emit(UiState.Success(data))
        } catch (e: Exception) {
            emit(UiState.Failure(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}