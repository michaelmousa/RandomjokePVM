package com.treehouse.randomjoke.network

import retrofit2.Call
import retrofit2.http.GET

interface popServices {

    @GET("https://api.chucknorris.io/")
    fun getRandomDetails(): Call<com.treehouse.randomjoke.model.Response>
}