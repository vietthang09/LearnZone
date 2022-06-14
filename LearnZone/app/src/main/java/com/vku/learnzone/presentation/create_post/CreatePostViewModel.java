package com.vku.learnzone.presentation.create_post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.PostApi;
import com.vku.learnzone.presentation.create_post.model.CreatePost_Request;
import com.vku.learnzone.presentation.create_post.model.CreatePost_Response;
import com.vku.learnzone.presentation.post_detail.model.PostRRequest;
import com.vku.learnzone.presentation.post_detail.model.PostResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreatePostViewModel extends ViewModel {
    private MutableLiveData<CreatePost_Response> createPostResponseMutableLiveData;

    public LiveData<CreatePost_Response> createPost(String accessToken, CreatePost_Request post) {
        if (createPostResponseMutableLiveData == null) {
            createPostResponseMutableLiveData = new MutableLiveData<>();
            loadCreatePost(accessToken, post);
        }
        return createPostResponseMutableLiveData;
    }

    private void loadCreatePost(String accessToken, CreatePost_Request post) {
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
        Call<CreatePost_Response> call = postApi.createPost(post);

        call.enqueue(new Callback<CreatePost_Response>() {
            @Override
            public void onResponse(Call<CreatePost_Response> call, Response<CreatePost_Response> response) {
                createPostResponseMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<CreatePost_Response> call, Throwable t) {

            }
        });
    }
}
