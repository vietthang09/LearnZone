package com.vku.learnzone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.white

@Composable
fun CategoryButton(icon: String, navController: NavController) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .background(
                color = white,
                shape = CircleShape
            )
            .clickable {
                navController.navigate(Screen.AwesomeCoursesScreen.route)
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            model = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}