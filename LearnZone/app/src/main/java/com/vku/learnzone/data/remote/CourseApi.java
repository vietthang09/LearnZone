package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.course_detail.model.Course;
import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;
import com.vku.learnzone.presentation.course_detail.model.CourseResponse;
import com.vku.learnzone.presentation.courses.model.Courses;
import com.vku.learnzone.presentation.home.model.RecentlyCourses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CourseApi {

    @POST("course/recently")
    Call<RecentlyCourses> getRecentlyCourses();

    @POST("course/all")
    Call<Courses> getAllCourses();

    @POST("course/getInfo")
    Call<CourseResponse> getCourseInfo(@Body CourseRequestBody courseRequestBody);
}
