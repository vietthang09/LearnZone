package com.vku.learnzone.presentation.forum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.PostApi;
import com.vku.learnzone.presentation.forum.model.Posts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForumViewModel extends ViewModel {
    private final String TAG = "ForumViewModel";
    private MutableLiveData<Posts> mListPost;

    public LiveData<Posts> getPosts() {
        if (mListPost == null) {
            mListPost = new MutableLiveData<>();
            loadPosts();
        }
        return mListPost;
    }

    private void loadPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit.create(PostApi.class);
        Call<Posts> call = postApi.getPosts();

        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                mListPost.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
            }
        });
    }
}
