package com.mexiti.catphotoapp.network

import com.mexiti.catphotoapp.model.CatPhoto
import retrofit2.http.GET

/*private const val BASE_URL = "https://api.thecatapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
*/
interface CatApiService{
    @GET("v1/images/search?limit=10")
    suspend fun getPhotos():List<CatPhoto>
}
/*
object CatApi {
    val retrofitService: CatApiService by lazy{
        retrofit.create(CatApiService::class.java)
    }
}*/