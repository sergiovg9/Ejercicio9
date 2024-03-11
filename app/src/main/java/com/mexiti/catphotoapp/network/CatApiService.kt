package com.mexiti.catphotoapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CatApiService{
    @GET("v1/images/search")
    suspend fun getPhotos():String
}

object CatApi {
    val retrofitService: CatApiService by lazy{
        retrofit.create(CatApiService::class.java)
    }
}