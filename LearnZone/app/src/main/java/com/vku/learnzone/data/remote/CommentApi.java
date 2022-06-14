package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;
import com.vku.learnzone.presentation.course_detail.model.CourseResponse;
import com.vku.learnzone.presentation.post_detail.model.CommentRequest;
import com.vku.learnzone.presentation.post_detail.model.CommentResponse;
import com.vku.learnzone.presentation.post_detail.model.Comments;
import com.vku.learnzone.presentation.post_detail.model.PostRRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CommentApi {
    @POST("comment/get-comments")
    Call<Comments> getComments(@Body PostRRequest postRRequest);

    @POST("comment/create")
    Call<CommentResponse> create(@Body CommentRequest commentRequest);
}
