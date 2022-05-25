package com.vku.learnzone.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vku.learnzone.component.CourseItem
import com.vku.learnzone.component.EnrollledCourseItem
import com.vku.learnzone.ui.theme.*
import com.vku.learnzone.utils.Data

@Composable
fun CoursesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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
                Data.courseList.forEach {
                    EnrollledCourseItem(
                        course = it,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}