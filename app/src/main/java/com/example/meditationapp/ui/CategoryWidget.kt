package com.example.meditationapp.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.Categories
import com.example.meditationapp.R
import com.example.meditationapp.ui.theme.Gray
import com.example.meditationapp.ui.theme.TextWhite

@Composable
fun CategoryItem(
    category : Categories
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.clip(RoundedCornerShape(18.dp)).background(color = Gray).padding(15.dp)
        ) {
           Icon(painter = painterResource(id = category.icon), contentDescription = "Category Icon", tint = TextWhite)
        }
        Text(
            text = category.title,
            style = MaterialTheme.typography.body1,
            fontSize = 10.sp,
            color = Gray
        )
    }
}