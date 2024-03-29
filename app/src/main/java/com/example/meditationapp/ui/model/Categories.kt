package com.example.meditationapp.ui.model

import com.example.meditationapp.R

data class Categories(
    val title : String,
    val icon : Int
)

val categoryList = listOf(
    Categories("All", R.drawable.ic_category_all),
    Categories("My", R.drawable.ic_category_my),
    Categories("Anxious", R.drawable.ic_category_anxious),
    Categories("Sleep", R.drawable.ic_category_sleep),
    Categories("Kids", R.drawable.ic_category_kids),
)
