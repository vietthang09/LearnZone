package com.vku.learnzone.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vku.learnzone.component.CourseItem
import com.vku.learnzone.ui.theme.*

@Composable
fun CoursesScreen() {
    Column(
        modifier = Modifier
            .background(ghost_white)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 30.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "My Enrolled Courses",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                for (i in 1..7) {
                    CourseItem(icon = "https://store.soft365.vn/wp-content/uploads/2018/10/logo-2.png")
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}