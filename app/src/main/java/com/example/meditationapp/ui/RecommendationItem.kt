package com.example.meditationapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.Recommendation
import com.example.meditationapp.ui.theme.DeepBlue
import com.example.meditationapp.ui.theme.dp10

@Composable
fun RecommendationItem(
    recommendation: Recommendation
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.wrapContentHeight()
    ) {
        Box(modifier = Modifier.clip(RoundedCornerShape(dp10)).padding(end = 15.dp)) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = "Recommendation Image"
            )
        }

        Text(
            text = recommendation.title,
            style = MaterialTheme.typography.h6,
            color = DeepBlue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 5.dp)
        )
        Text(
            text = recommendation.description,
            color = Color.LightGray,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 10.sp
        )
    }
}