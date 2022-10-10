package com.example.asteroidneoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.asteroidneoapp.repository.AsteroidRepository
import javax.inject.Inject

class MainViewModelFactory@Inject constructor(private val repository:AsteroidRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass:Class<T>): T
    {
     return MainViewModel(repository) as T
    }
}