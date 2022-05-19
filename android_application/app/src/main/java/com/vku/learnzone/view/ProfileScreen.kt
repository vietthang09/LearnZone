package com.vku.learnzone.view

import android.app.DatePickerDialog
import androidx.compose.ui.geometry.Size
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vku.learnzone.ui.theme.*
import java.util.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.toSize

@Composable
fun ProfileScreen() {

    val context = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember {
        mutableStateOf("01/01/2000")
    }

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )

    var mExpanded by remember { mutableStateOf(false) }

    val mGenders = listOf("Male", "Female")

    var mSelectedText by remember { mutableStateOf("Male") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(
        modifier = Modifier
            .background(ghost_white)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 50.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // avatar

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        model = "https://i.pravatar.cc/150?img=52",
                        contentDescription = "Avatar"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column() {
                        Text(
                            text = "Daniel Sebastian",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "daniel.sebastian@yourdoamin.com",
                            fontSize = 11.sp,
                            color = light_gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 32.dp))

                // information
                Column() {
                    Text(
                        text = "Full Name", style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    TextField(
                        value = "Daniel Sebastian",
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = white,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = {}
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Email", style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    TextField(
                        value = "daniel.sebastian@yourdoamin.com",
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = white,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = {}
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Date of birth", style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(white)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Text(
                            text = mDate.value,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)
                                .clickable { mDatePickerDialog.show() },
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Gender", style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Column() {
                        TextField(
                            value = mSelectedText,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = white,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            textStyle = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    mTextFieldSize = coordinates.size.toSize()
                                },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            shape = RoundedCornerShape(8.dp),
                            trailingIcon = {
                                Icon(icon, "",
                                    Modifier.clickable { mExpanded = !mExpanded })
                            },
                            onValueChange = { mSelectedText = it }
                        )

                        DropdownMenu(
                            expanded = mExpanded,
                            onDismissRequest = { mExpanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
                        ) {
                            mGenders.forEach { label ->
                                DropdownMenuItem(onClick = {
                                    mSelectedText = label
                                    mExpanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Address", style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    TextField(
                        value = "Bung Tomo St.067",
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = white,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = {}
                    )
                }
            }
        }
    }
}