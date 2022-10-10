package com.example.asteroidneoapp.retrofit

import com.example.asteroidneoapp.utils.Constants.API_KEY
import com.example.asteroidneoapplication.models.AsteroidResponse
import retrofit2.Response
import retrofit2.http.*

interface AsteroidAPI {
    @GET("neo/rest/v1/feed")
   suspend fun getAsteroidDetails(
        @Query("start_date") startDate:String,
        @Query("end_date") endDate:String,
        @Query("api_key") apiKey:String=API_KEY,
    ): Response<AsteroidResponse>
}