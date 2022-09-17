package com.example.meditationapp.model

import androidx.compose.ui.graphics.Color
import com.example.meditationapp.R
import com.example.meditationapp.ui.theme.*

data class Topic(
    val title: String,
    val image: Int,
    val color : Color,
    val textColor : Color
)

val topicList = listOf(
    Topic("Reduce Stress", R.drawable.ic_topic_1, Blue, TextWhite),
    Topic("Improve Performance", R.drawable.ic_topic_2, Red, TextWhite),
    Topic("Increase Happiness", R.drawable.ic_topic_3, LightOrange, DeepBlue),
    Topic("Reduce Anxiety", R.drawable.ic_topic_4, Color.Yellow, DeepBlue),
    Topic("Personal Growth", R.drawable.ic_topic_5, Green, TextWhite),
    Topic("Better Sleep", R.drawable.ic_topic_6, DarkGray, TextWhite),
    Topic("Reduce Stress", R.drawable.ic_topic_1, Blue, TextWhite),
    Topic("Improve Performance", R.drawable.ic_topic_2, Red, TextWhite)
)
