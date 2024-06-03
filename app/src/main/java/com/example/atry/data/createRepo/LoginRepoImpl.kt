package com.example.atry.data.createRepo

import com.example.atry.data.model.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class LoginRepoImpl  @Inject constructor(firestore: FirebaseFirestore):LoginRepository {

    override suspend fun getUserByEmail(email: String): UserInfo {
        TODO("Not yet implemented")
    }

}