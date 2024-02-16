package kz.tutorial.jsonplaceholdertypicode.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable