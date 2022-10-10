package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AsteroidResponse(
    val near_earth_objects:  Map<String, List<NearEarthObjects>>
) : Parcelable