package com.vku.learnzone.network

import com.vku.learnzone.model.Course
import com.vku.learnzone.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("api/courses")
    suspend fun getCourses(): List<Course>

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}