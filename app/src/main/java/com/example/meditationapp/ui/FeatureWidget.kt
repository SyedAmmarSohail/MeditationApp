package com.example.meditationapp.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.Feature
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.TextWhite
import com.example.meditationapp.ui.theme.dp10

@Composable
fun FeatureItem(
    feature: Feature,
    modifier: Modifier = Modifier,
    textColor : Color
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxHeight().padding(start = 15.dp)
            ) {
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.h6,
                    color = textColor
                )
                Text(
                    text = feature.description,
                    color = textColor,
                    style = MaterialTheme.typography.body1
                )
            }

            Image(
                painter = painterResource(id = feature.image),
                contentDescription = feature.title,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(bottom = 15.dp, start = 15.dp, end = 15.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = feature.time,
                    color = textColor,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            // Handle the click
                        }
                        .clip(RoundedCornerShape(12.dp))
                        .background(ButtonBlue)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )
            }
        }
    }
}