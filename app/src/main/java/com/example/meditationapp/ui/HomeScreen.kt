package com.example.meditationapp.ui

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.meditationapp.*
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
        Spacer(modifier = Modifier.height(10.dp))
        CategoriesSection(
            listOf(
                Categories("All", R.drawable.ic_category_all),
                Categories("My", R.drawable.ic_category_my),
                Categories("Anxious", R.drawable.ic_category_anxious),
                Categories("Sleep", R.drawable.ic_category_sleep),
                Categories("Kids", R.drawable.ic_category_kids),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        FeatureSection()
        Spacer(modifier = Modifier.height(20.dp))
        DailyThoughtsSection()
        spacerHeight10()
        spacerHeight10()
        RecommendationSection(
            listOf<Recommendation>(
                Recommendation(
                    "Focus",
                    description = "MEDITATION 3-10 MIN",
                    R.drawable.ic_recommendation_1
                ),
                Recommendation(
                    "Happiness",
                    description = "MEDITATION 3-10 MIN",
                    R.drawable.ic_recommendation_2
                ),
                Recommendation(
                    "Focus",
                    description = "MEDITATION 3-10 MIN",
                    R.drawable.ic_recommendation_1
                ),
                Recommendation(
                    "Happiness",
                    description = "MEDITATION 3-10 MIN",
                    R.drawable.ic_recommendation_2
                ),
            )
        )

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
        Text(
            text = stringResource(R.string.good_morning) + " $name",
            style = MaterialTheme.typography.h1
        )
        spacerHeight5()
        Text(text = stringResource(R.string.wishing_desc), style = MaterialTheme.typography.h2)
    }
}

@Composable
fun FeatureSection() {
    Row(
    ) {
        FeatureItem(
            Feature("Basics", description = "Course", R.drawable.ic_feature_1, "3-10 MIN"),
            Modifier
                .weight(1f)
                .padding(end = 7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dp10))
                .background(Blue)
                .wrapContentHeight(), TextWhite
        )
        FeatureItem(
            Feature("Relaxation", "Music", R.drawable.ic_logo, "3-10 MIN"), Modifier
                .weight(1f)
                .padding(start = 7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dp10))
                .background(Orange)
                .wrapContentHeight(), DeepBlue
        )
    }
}

@Composable
fun DailyThoughtsSection() {
    DailyThoughtsItem(
        DailyThought(
            stringResource(R.string.daily_thoughts),
            "MEDITATION 3-10 MIN",
            TextWhite
        )
    )
}

@Composable
fun RecommendationSection(recommendationList: List<Recommendation>) {
    Column {
        Text(
            text = stringResource(R.string.recommendations),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start
        )
    }
    spacerHeight10()
    LazyRow() {
        items(recommendationList.size) {
            RecommendationItem(recommendation = recommendationList[it])
        }
    }
}

@Composable
fun CategoriesSection(categoriesList: List<Categories>) {
    LazyRow() {
        items(categoriesList.size) {
            CategoryItem(category = categoriesList[it])
        }
    }
}