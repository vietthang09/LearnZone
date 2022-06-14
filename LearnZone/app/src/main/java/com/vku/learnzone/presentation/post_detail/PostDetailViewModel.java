package com.vku.learnzone.presentation.post_detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.CommentApi;
import com.vku.learnzone.data.remote.CourseApi;
import com.vku.learnzone.data.remote.PostApi;
import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;
import com.vku.learnzone.presentation.course_detail.model.CourseResponse;
import com.vku.learnzone.presentation.post_detail.model.CommentRequest;
import com.vku.learnzone.presentation.post_detail.model.CommentResponse;
import com.vku.learnzone.presentation.post_detail.model.Comments;
import com.vku.learnzone.presentation.post_detail.model.PostRRequest;
import com.vku.learnzone.presentation.post_detail.model.PostResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostDetailViewModel extends ViewModel {
    private MutableLiveData<PostResponse> postResponseMutableLiveData;
    private MutableLiveData<Comments> commentsMutableLiveData;
    private MutableLiveData<CommentResponse> commentResponseMutableLiveData;

    public LiveData<PostResponse> getPost(String accessToken, int id) {
        if (postResponseMutableLiveData == null) {
            postResponseMutableLiveData = new MutableLiveData<>();
            loadPost(accessToken, id);
        }
        return postResponseMutableLiveData;
    }

    private void loadPost(String accessToken, int id) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        PostApi postApi = retrofit.create(PostApi.class);
        Call<PostResponse> call = postApi.getPost(new PostRRequest(id));

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                postResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
    }

    /// =================================================================
    public LiveData<Comments> getComments(String accessToken, int id) {
        if (commentsMutableLiveData == null) {
            commentsMutableLiveData = new MutableLiveData<>();
            loadComments(accessToken, id);
        }
        return commentsMutableLiveData;
    }

    private void loadComments(String accessToken, int id) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        CommentApi commentApi = retrofit.create(CommentApi.class);
        Call<Comments> call = commentApi.getComments(new PostRRequest(id));

        call.enqueue(new Callback<Comments>() {
            @Override
            public void onResponse(Call<Comments> call, Response<Comments> response) {
                commentsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Comments> call, Throwable t) {

            }
        });

    }

    // ===================================================
    public LiveData<CommentResponse> create(String accessToken, int id, String content) {
        if (commentResponseMutableLiveData == null) {
            commentResponseMutableLiveData = new MutableLiveData<>();
            loadCreate(accessToken, id, content);
        }
        return commentResponseMutableLiveData;
    }

    private void loadCreate(String accessToken, int id, String content) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        CommentApi commentApi = retrofit.create(CommentApi.class);
        Call<CommentResponse> call = commentApi.create(new CommentRequest(id, content));

        call.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                commentResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {

            }
        });

    }
}
