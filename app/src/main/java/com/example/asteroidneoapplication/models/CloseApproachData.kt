package com.example.asteroidneoapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CloseApproachData(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val miss_distance: MissDistance,
    val relative_velocity: RelativeVelocity
) : Parcelable
