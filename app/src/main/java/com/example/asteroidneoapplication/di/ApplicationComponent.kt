package com.example.asteroidneoapp.di

import com.example.asteroidneoapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[NetworkModule::class])
interface ApplicationComponent {
 fun inject(fragment : HomeFragment)

}
