package com.vku.learnzone.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.vku.learnzone.R
import com.vku.learnzone.component.CategoryButton
import com.vku.learnzone.component.CourseItem
import com.vku.learnzone.navigation.Screen
import com.vku.learnzone.ui.theme.*
import com.vku.learnzone.utils.Data
import com.vku.learnzone.viewmodel.CourseViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: CourseViewModel) {
//    LaunchedEffect(Unit, block = {
//        viewModel.getCourseList()
//    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (logoimageref, loginformref) = createRefs()

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                HeaderHome(navController = navController)
            }
            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, end = 20.dp, bottom = 50.dp, start = 20.dp)
                ) {
                    PromotionSection()
                    AwesomeCoursesSection(navController = navController)
                }
            }
        }
    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row() {
//                        Text("Todos")
//                    }
//                })
//        },
//        content = {
//            if (viewModel.errorMessage.isEmpty()) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
//                        items(viewModel.courseList) { course ->
//                            Column {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(16.dp),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(0.dp, 0.dp, 16.dp, 0.dp)
//                                    ) {
//                                        Text(
//                                            course.title,
//                                            maxLines = 1,
//                                            overflow = TextOverflow.Ellipsis
//                                        )
//                                    }
//                                }
//                                Divider()
//                            }
//                        }
//                    }
//                }
//            } else {
//                Text(viewModel.errorMessage)
//            }
//        }
//    )
}

@Composable
fun HeaderHome(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "LearnZone",
            color = white,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(start = 120.dp)
        )
    }
}

@Composable
fun PromotionSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Promotion",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {}) {
            Text(
                text = "See all",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Image(
        painter = painterResource(id = R.drawable.ic_sale_banner),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.padding(10.dp))
}

@Composable
fun AwesomeCoursesSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Awesome Courses",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {
            navController.navigate(Screen.CategoriesScreen.route)
        }) {
            Text(
                text = "See all",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    CategoryView(navController = navController)
    Spacer(modifier = Modifier.padding(10.dp))
    CourseItems(navController)
}

@Composable
fun CategoryView(navController: NavController) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        Data.categoryList.forEach {
            CategoryButton(
                icon = it,
                navController = navController
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun CourseItems(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Data.courseList.forEach {
            CourseItem(
                course = it,
                navController = navController
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
