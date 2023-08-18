package com.example.randomuserapplication.di

import com.example.randomuserapplication.network.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit {

    }


}