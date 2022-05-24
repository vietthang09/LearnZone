package com.vku.learnzone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                shape = RoundedCornerShape(18.dp)
            )
            .padding(18.dp)
            .clickable {
                navController.navigate(Screen.AwesomeCoursesScreen.route)
            }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = icon,
            contentDescription = null
        )
    }
}