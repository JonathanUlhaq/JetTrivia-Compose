package com.belajar.jettrivia.network

import com.belajar.jettrivia.models.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface TriviaAPI {

    @GET("world.json")
    suspend fun getAllData():Question

}