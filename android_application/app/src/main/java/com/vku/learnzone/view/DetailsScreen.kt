package com.vku.learnzone.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vku.learnzone.component.TestimonialItem
import com.vku.learnzone.component.VideoItem
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.*
import com.vku.learnzone.utils.Data

@Composable
fun DetailsScreen(navController: NavController) {
    Column(
        modifier = Modifier
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
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "3D Design Basic",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ConstraintLayout {
                val (imagesliderref, addtocartref) = createRefs()
                Box(modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp)
                    .constrainAs(imagesliderref) {
                        top.linkTo(imagesliderref.top)
                        bottom.linkTo(imagesliderref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                    HeaderImagesSlider(Data.videoList[0].image)
                }
                Surface(color = colorPrimary,
                    shape = RoundedCornerShape(40.dp)
                        .copy(
                            bottomStart = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        ), modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 220.dp)
                        .constrainAs(addtocartref) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {
                        CourseTitleSubtitle()
                        Spacer(modifier = Modifier.padding(10.dp))
                        Divider(color = colorPrimaryWhite, thickness = 1.dp)
                        Spacer(modifier = Modifier.padding(20.dp))
                        CourseAbout()
                        Spacer(modifier = Modifier.padding(20.dp))
                        VideosSection()
                        Spacer(modifier = Modifier.padding(10.dp))
                        TestimonialsSection(navController = navController)
                        Spacer(modifier = Modifier.padding(10.dp))
                        EnrollButton(navController)
                    }

                }

            }
        }
    }
}

@Composable
fun CourseTitleSubtitle() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "3D Design Basic",
            style = MaterialTheme.typography.h6,
            color = white
        )
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "24 lessons,",
                style = MaterialTheme.typography.caption,
                color = white
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Start",
                tint = white,
                modifier = Modifier
                    .size(16.dp)
            )
            Text(
                text = "4.9",
                fontSize = 10.sp,
                color = white,
                fontWeight = FontWeight.Light
            )
        }

    }
}

@Composable
fun CourseAbout() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "About",
            style = MaterialTheme.typography.h6,
            color = white
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "In this course, you will learn how to build a space to a 3 dimensional production. There are 24 premium learning videos for you.",
            style = MaterialTheme.typography.caption,
            color = white
        )
    }
}

@Composable
fun EnrollButton(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { navController.navigate(Screen.EnrollmentScreen.route) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = white),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Enroll - $24.99",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }

}


@Composable
fun HeaderImagesSlider(image: String) {
    AsyncImage(
        model = image,
        contentDescription = "",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun VideosSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "24 Lessons (20 hours)",
            style = MaterialTheme.typography.h6,
            color = white
        )
        TextButton(onClick = {}) {
            Text(
                text = "See all",
                color = white
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    VideoItem(Data.videoList[0])
}

@Composable
fun TestimonialsSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Testimonials",
            style = MaterialTheme.typography.h6,
            color = white
        )
        TextButton(onClick = { navController.navigate(Screen.TestimonialsScreen.route) }) {
            Text(
                text = "See all",
                color = white
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    TestimonialItem()
}