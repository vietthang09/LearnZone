package com.vku.learnzone.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vku.learnzone.component.CategoryButton
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.ghost_white
import com.vku.learnzone.ui.theme.light_gray
import com.vku.learnzone.ui.theme.white
import com.vku.learnzone.utils.Data

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesScreen(navController: NavController) {
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
                    text = "Categories",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        TextField(
            value = "",
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
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
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            cells = GridCells.Fixed(4),
            content = {
                items(Data.categoryList.size) { index ->
                    Box(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        CategoryButton(
                            icon = Data.categoryList[index],
                            navController = navController
                        )
                    }
                }
            })
    }

}