package com.example.meditationapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.meditationapp.Topic

@Composable
fun TopicItem(
    topic : Topic
){
    Box(modifier = Modifier.wrapContentHeight()){
        Image(painter = painterResource(id = topic.image), contentDescription = "Topic")
        Text(topic.title, style = MaterialTheme.typography.h2, fontSize = 14.sp, modifier = Modifier.align(
            Alignment.BottomStart))
    }
}