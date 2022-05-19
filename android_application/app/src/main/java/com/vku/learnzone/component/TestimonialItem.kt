package com.vku.learnzone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.AsyncImage
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.*

@Composable
fun TestimonialItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(white)
            .clickable { }
    ) {
        // Image
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .clip(CircleShape),
            model = "https://i.pravatar.cc/150?img=52",
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
                    text = "Jenny Wilson",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = black
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Text(
                    text = "December 20, 2022",
                    fontSize = 10.sp,
                    color = light_gray,
                    fontWeight = FontWeight.Light
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Text(
                    text = "The course is awesome!",
                    fontSize = 11.sp,
                    color = gray,
                    fontWeight = FontWeight.Light
                )
            }
            // Price
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorPrimary)
            ) {
                Row(modifier = Modifier.padding(3.dp)) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = white
                    )
                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                    )
                    Text(
                        text = "5",
                        fontSize = 16.sp,
                        color = white,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}