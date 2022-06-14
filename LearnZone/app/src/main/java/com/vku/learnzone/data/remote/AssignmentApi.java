package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.course_detail.model.Assignments;
import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AssignmentApi {
    @POST("assignment/number-today")
    Call<String> numberOfAssignmentToday();

    @POST("assignment/timeline")
    Call<com.vku.learnzone.presentation.home.model.Assignments> getAllAssignmentsMini();

    @POST("assignment/in-course")
    Call<Assignments> getAssignmentsOfCourse(@Body CourseRequestBody courseRequestBody);
}
