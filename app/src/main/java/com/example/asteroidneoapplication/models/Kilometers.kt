package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kilometers(
val estimated_diameter_max: Double,
val estimated_diameter_min: Double
) : Parcelable
