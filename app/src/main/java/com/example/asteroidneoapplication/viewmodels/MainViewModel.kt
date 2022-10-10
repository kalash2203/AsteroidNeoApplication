package com.example.asteroidneoapp.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asteroidneoapp.repository.AsteroidRepository
import com.example.asteroidneoapplication.models.AsteroidResponse
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainViewModel(val repository: AsteroidRepository): ViewModel() {
    val asteroidsLiveData: LiveData<AsteroidResponse>
        get() = repository.asteroid

    fun getAsteroidData(start_date: String, end_date: String) {
        viewModelScope.launch {
            repository.getAsteroidDetails(start_date, end_date)
        }
    }

    fun checkIsEmpty(start_date: String, end_date: String): Boolean {
        if (start_date.isEmpty() && end_date.isEmpty())
            return false
        else
            return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkDifferenceOfDates(start_date: String, end_date: String): Boolean {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        try {
            val dateStart: Date = sdf.parse(start_date)
            val timeInMillisecondsStart = dateStart.time
            val dateEnd: Date = sdf.parse(end_date)
            val timeInMillisecondsEnd = dateEnd.time
            if (((timeInMillisecondsEnd - timeInMillisecondsStart) / 1000 * 60 * 60 * 24) <= 7)
                return true
            else
                false
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return false
    }

}