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
import com.vku.learnzone.ui.theme.*

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
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = colorPrimary,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.popBackStack() })
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
                    HeaderImagesSlider("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Laravel.svg/1200px-Laravel.svg.png")
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
                        FlowerTitleSubtitle()
                        Spacer(modifier = Modifier.padding(10.dp))
                        AddtoCartPrice()
                        Spacer(modifier = Modifier.padding(10.dp))
                        Divider(color = colorPrimaryWhite, thickness = 1.dp)
                        Spacer(modifier = Modifier.padding(20.dp))
                        FlowerAbout()
                        Spacer(modifier = Modifier.padding(20.dp))
                        FlowerAddtoCartButton(navController)
                    }

                }

            }
        }
    }
}

@Composable
fun FlowerTitleSubtitle() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Jannien Flower Bouquet",
            style = MaterialTheme.typography.h6,
            color = white
        )

        Text(
            text = "includes jannein flower, lily leaves",
            style = MaterialTheme.typography.caption,
            color = white
        )
    }
}

@Composable
fun AddtoCartPrice() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$567.00",
            color = white,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FlowerAbout() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "About",
            style = MaterialTheme.typography.h6,
            color = white
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Lorem ipsum is simply dummy text of the printing and \n" +
                    "typesetting industry. Loremk ipsum has been the industy's \n" +
                    "standard dummy text ever since the 1500s.",
            style = MaterialTheme.typography.caption,
            color = white
        )
    }
}

@Composable
fun FlowerAddtoCartButton(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = white),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp, 20.dp)
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

//    Column(
//        modifier = Modifier
//            .background(ghost_white)
//            .verticalScroll(rememberScrollState())
//            .padding(bottom = 30.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(20.dp)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "",
//                    tint = colorPrimary,
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clickable { navController.popBackStack() })
//                Text(
//                    text = "3D Design Basic",
//                    style = MaterialTheme.typography.h5,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Spacer(modifier = Modifier.height(10.dp))
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                HeaderImage(image = "https://cdn.dribbble.com/users/323673/screenshots/14425154/media/c9766811449634cab83a657a51c8448c.png?compress=1&resize=400x300&vertical=top")
//                Surface(
//                    color = colorPrimary,
//                    shape = RoundedCornerShape(40.dp)
//                        .copy(
//                            bottomStart = ZeroCornerSize, bottomEnd = ZeroCornerSize
//                        ),
//                    modifier = Modifier.fillMaxSize().
//                ) {
//
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun HeaderImage(image: String) {
//    AsyncImage(
//        model = image,
//        contentDescription = "",
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(200.dp)
//            .clip(RoundedCornerShape(8.dp))
//    )
//}