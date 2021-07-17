package com.example.clean_architecture_2021.recyclerview.sample.data

import androidx.annotation.DrawableRes

data class Flower(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String,
)