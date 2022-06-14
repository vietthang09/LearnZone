package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.course_detail.model.Assignments;
import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;
import com.vku.learnzone.presentation.course_detail.model.Materials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MaterialApi {

    @POST("material/in-course")
    Call<Materials> getMaterialsInCourse(@Body CourseRequestBody courseRequestBody);
}
