package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EstimatedDiameter(
    val kilometers: Kilometers

) : Parcelable

