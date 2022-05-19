package com.vku.learnzone.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vku.learnzone.model.Course
import com.vku.learnzone.network.APIService
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {
    private val _courseList = mutableStateListOf<Course>()
    var errorMessage: String by mutableStateOf("")
    val courseList: List<Course>
        get() = _courseList

    fun getCourseList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _courseList.clear()
                _courseList.addAll(apiService.getCourses())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}