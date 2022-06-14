package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.create_post.model.CreatePost_Request;
import com.vku.learnzone.presentation.create_post.model.CreatePost_Response;
import com.vku.learnzone.presentation.forum.model.Posts;
import com.vku.learnzone.presentation.post_detail.model.PostRRequest;
import com.vku.learnzone.presentation.post_detail.model.PostResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PostApi {
    @GET("forum/posts")
    Call<Posts> getPosts();

    @POST("forum/get-post")
    Call<PostResponse> getPost(@Body PostRRequest postRRequest);

    @POST("forum/create")
    Call<CreatePost_Response> createPost(@Body CreatePost_Request body);
}
