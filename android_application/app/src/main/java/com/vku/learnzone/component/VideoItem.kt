package com.vku.learnzone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vku.learnzone.model.Video
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.black
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.gray
import com.vku.learnzone.ui.theme.white

@Composable
fun VideoItem(video: Video) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(white)
            .clickable { }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp),
            model = video.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        ) {
            Column {
                Text(
                    text = video.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = black
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                Text(
                    text = "${video.duration} mins",
                    fontSize = 11.sp,
                    color = gray,
                    fontWeight = FontWeight.Light
                )
            }
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Favorite",
                tint = colorPrimary
            )
        }
    }
}