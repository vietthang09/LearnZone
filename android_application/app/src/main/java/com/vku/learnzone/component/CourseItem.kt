package com.vku.learnzone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vku.learnzone.navigation.Navigation
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.black
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.gray
import com.vku.learnzone.ui.theme.white

@Composable
fun CourseItem(icon: String, navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(white)
            .clickable { navController.navigate(Screen.DetailsScreen.route) }
    ) {
        // Image
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp),
            model = icon,
            contentDescription = null
        )
        // Title + Price
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        ) {
            // Title
            Column {
                Text(
                    text = "3D Design Basic",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = black
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Text(
                    text = "24 lessons",
                    fontSize = 11.sp,
                    color = gray,
                    fontWeight = FontWeight.Light
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Start",
                        tint = colorPrimary,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "4.9",
                        fontSize = 10.sp,
                        color = gray,
                        fontWeight = FontWeight.Light
                    )
                }
            }
            // Price
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = colorPrimary
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Text(
                    text = "$24.99",
                    fontSize = 16.sp,
                    color = colorPrimary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}