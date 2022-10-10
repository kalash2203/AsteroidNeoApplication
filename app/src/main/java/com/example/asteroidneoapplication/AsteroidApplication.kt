package com.example.asteroidneoapplication

import android.app.Application
import com.example.asteroidneoapp.di.ApplicationComponent
import com.example.asteroidneoapp.di.DaggerApplicationComponent
import dagger.Component

class AsteroidApplication : Application(){
  lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {

        super.onCreate()
        applicationComponent= DaggerApplicationComponent.builder()
               .build()
    }
}