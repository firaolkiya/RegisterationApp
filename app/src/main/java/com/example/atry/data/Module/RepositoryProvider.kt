package com.example.atry.data.Module

import com.example.atry.data.createRepo.HomageRepoImpl
import com.example.atry.data.createRepo.HomepageRepository
import com.example.atry.data.createRepo.LoginRepoImpl
import com.example.atry.data.createRepo.LoginRepository
import com.example.atry.data.createRepo.UserRepo
import com.example.atry.data.createRepo.UserRepoImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryProvider {

    @Singleton
    @Provides
    fun ProvideCreateAccountRepository(firebase: FirebaseFirestore):UserRepo{
        return UserRepoImpl(firestore = firebase)
    }

    @Singleton
    @Provides
    fun ProvideLoginepository(firebase: FirebaseFirestore): LoginRepository {
        return  LoginRepoImpl(firestore = firebase)
    }

    @Singleton
    @Provides
    fun ProvidesHomepageRepo(firebase: FirebaseFirestore): HomepageRepository {
        return  HomageRepoImpl(firestore = firebase)
    }
}

