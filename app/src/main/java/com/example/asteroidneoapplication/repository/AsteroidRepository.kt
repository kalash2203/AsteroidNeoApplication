package com.example.asteroidneoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.asteroidneoapp.retrofit.AsteroidAPI
import com.example.asteroidneoapplication.models.AsteroidResponse
import javax.inject.Inject

class AsteroidRepository @Inject constructor(private val asteroidAPI: AsteroidAPI){
  private val _asteroids=MutableLiveData<AsteroidResponse>()
   val asteroid: LiveData<AsteroidResponse>
   get()=_asteroids

    suspend fun getAsteroidDetails(start_date:String,end_date:String)
    {
       val result=asteroidAPI.getAsteroidDetails(start_date,end_date)
       if(result.isSuccessful && result.body()!=null)
       {
           _asteroids.postValue((result.body()))
       }
    }


}