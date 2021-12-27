package com.example.meditationapp.ui

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(bottom = 120.dp)

        ) {
            appTitle()
            spacerHeight10()
            greetingSection(name = "Ammar")
            spacerHeight20()
            CategoriesSection(
                listOf(
                    Categories("All", R.drawable.ic_category_all),
                    Categories("My", R.drawable.ic_category_my),
                    Categories("Anxious", R.drawable.ic_category_anxious),
                    Categories("Sleep", R.drawable.ic_category_sleep),
                    Categories("Kids", R.drawable.ic_category_kids),
                )
            )
            spacerHeight20()
            FeatureSection()
            spacerHeight20()
            DailyThoughtsSection()
            spacerHeight20()
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

        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Sleep",R.drawable.ic_sleep),
            BottomMenuContent("Meditate", R.drawable.ic_meditate),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun appTitle(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 15.dp),
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
    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(
            text = stringResource(R.string.good_morning) + " $name",
            style = MaterialTheme.typography.h1,
            fontSize = 22.sp
        )
        Text(text = stringResource(R.string.wishing_desc), style = MaterialTheme.typography.body1, color = LightGray, fontSize = 18.sp)
    }
}

@Composable
fun FeatureSection() {
    Row(
        modifier = Modifier.padding(horizontal = 15.dp)
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
    Box(modifier = Modifier.padding(horizontal = 15.dp)){
        DailyThoughtsItem(
            DailyThought(
                stringResource(R.string.daily_thoughts),
                "MEDITATION 3-10 MIN",
                TextWhite
            )
        )
    }

}

@Composable
fun RecommendationSection(recommendationList: List<Recommendation>) {
    Column(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        Text(
            text = stringResource(R.string.recommendations),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )
        spacerHeight10()
        LazyRow() {
            items(recommendationList.size) {
                RecommendationItem(recommendation = recommendationList[it])
            }
        }
    }
}

@Composable
fun CategoriesSection(categoriesList: List<Categories>, initialSelectedItemIndex : Int = 0) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    LazyRow(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        items(categoriesList.size) {
            CategoryItem(category = categoriesList[it], selectedItem = selectedItemIndex == it){
                selectedItemIndex = it
            }
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Blue,
    activeTextColor: Color = Blue,
    inactiveTextColor: Color = Gray,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Box(modifier = modifier.shadow(elevation = 8.dp)){
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(White)
                .padding(15.dp)
                .height(80.dp)
        ) {
            items.forEachIndexed { index, item ->
                BottomMenuItem(
                    item = item,
                    isSelected = index == selectedItemIndex,
                    activeHighlightColor = activeHighlightColor,
                    activeTextColor = activeTextColor,
                    inactiveTextColor = inactiveTextColor
                ) {
                    selectedItemIndex = index
                }
            }
        }
    }
}