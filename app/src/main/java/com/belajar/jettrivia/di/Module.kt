package com.belajar.jettrivia.di

import com.belajar.jettrivia.network.TriviaAPI
import com.belajar.jettrivia.repositories.TriviaRepository
import com.belajar.jettrivia.util.Constant
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@dagger.Module
object Module {

    @Singleton
    @Provides
    fun provideQuestRepository(api:TriviaAPI) = TriviaRepository(api)

    @Singleton
    @Provides
    fun provideQuestAPI():TriviaAPI =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TriviaAPI::class.java)
}