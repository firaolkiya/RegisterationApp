package com.example.atry.data.Module

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseProvider {

    @Singleton
    @Provides
    fun ProvideFirebase():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }
}