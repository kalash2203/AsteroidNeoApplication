package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RelativeVelocity(
    val kilometers_per_hour: String
):Parcelable
