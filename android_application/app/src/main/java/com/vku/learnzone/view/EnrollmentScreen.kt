package com.vku.learnzone.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.light_gray
import com.vku.learnzone.ui.theme.white
import com.vku.learnzone.utils.Data

@Composable
fun EnrollmentScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = Data.videoList[0].image,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = "3D Design Basic",
            style = MaterialTheme.typography.h6,
            color = white
        )
        Text(
            text = "Congrats!",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = colorPrimary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Course is successfully enrolled",
            style = MaterialTheme.typography.h6,
            fontSize = 12.sp,
            color = light_gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { navController.navigate(Screen.DetailsScreen.route) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Go to course",
                    color = white,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}