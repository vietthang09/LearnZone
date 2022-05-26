package com.vku.learnzone.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vku.learnzone.component.TestimonialItem
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.ghost_white

@Composable
fun TestimonialsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(ghost_white)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .border(2.dp, colorPrimary, RoundedCornerShape(8.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = colorPrimary,
                        modifier = Modifier
                            .padding(3.dp)
                            .size(32.dp)
                            .clickable { navController.popBackStack() })
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Testimonials",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            for (i in 1..5) {
                TestimonialItem()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}