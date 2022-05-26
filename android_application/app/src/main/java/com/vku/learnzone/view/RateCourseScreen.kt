package com.vku.learnzone.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.ghost_white
import com.vku.learnzone.ui.theme.light_gray
import com.vku.learnzone.ui.theme.white
import com.vku.learnzone.utils.Data

@Composable
fun RateCourseScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ghost_white)
            .verticalScroll(rememberScrollState())
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
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
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
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "3D Design Basic",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Please rate the course",
                style = MaterialTheme.typography.h6,
                fontSize = 12.sp,
                color = light_gray
            )
            Row {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = colorPrimary,
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = colorPrimary,
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = colorPrimary,
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = colorPrimary,
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = colorPrimary,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "",
                leadingIcon = {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = null,
                                tint = colorPrimary
                            )
                            Canvas(
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(start = 10.dp)
                            ) {
                                drawLine(
                                    color = light_gray,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height),
                                    strokeWidth = 2.0F
                                )
                            }
                        }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { },
                shape = RoundedCornerShape(8.dp),
                onValueChange = {}
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
                        text = "Submit",
                        color = white,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}