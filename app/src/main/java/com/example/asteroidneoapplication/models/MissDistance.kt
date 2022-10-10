package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MissDistance(
    val kilometers: String
) : Parcelable

