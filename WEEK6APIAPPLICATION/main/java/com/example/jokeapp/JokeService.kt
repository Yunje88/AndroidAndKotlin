package com.example.jokeapp

import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("joke/Programming?type=single/")
    fun ApiService(): Call<JokeData>
}