package com.example.meditationapp.ui

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationapp.Feature
import com.example.meditationapp.R
import com.example.meditationapp.ui.theme.*

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        appTitle()
        Spacer(modifier = Modifier.height(40.dp))
        greetingSection(name = "Ammar")
        Spacer(modifier = Modifier.height(30.dp))
        FeatureSection()

    }
}

@Composable
fun appTitle(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.silent),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "App Icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = stringResource(R.string.moon), style = MaterialTheme.typography.body1)
    }
}

@Composable
fun greetingSection(
    modifier: Modifier = Modifier.wrapContentHeight(),
    name: String = "Your Name"
) {
    Column {
        Text(text = stringResource(R.string.good_morning) + " $name", style = MaterialTheme.typography.h1)
        spacerHeight5()
        Text(text = stringResource(R.string.wishing_desc), style = MaterialTheme.typography.h2)
    }
}

@Composable
fun FeatureSection(){
    Row(
    ) {
        FeatureItem(Feature("Basics", description = "Course", R.drawable.ic_feature_1, "3-10 MIN"), Modifier
            .weight(1f)
            .padding(end = 7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(dp10))
            .background(Blue).wrapContentHeight(), TextWhite)
        FeatureItem(Feature("Relaxation", "Music", R.drawable.ic_logo, "3-10 MIN"), Modifier
            .weight(1f)
            .padding(start = 7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(dp10))
            .background(Orange).wrapContentHeight(), DeepBlue)
    }
//    Row() {
//        Column(
//            Modifier.weight(1f).background(Blue)){
//            Text(text = "Weight = 1", color = Color.White)
//        }
//        Column(
//            Modifier.weight(1f).background(Yellow)
//        ) {
//            Text(text = "Weight = 2")
//        }
//    }
}