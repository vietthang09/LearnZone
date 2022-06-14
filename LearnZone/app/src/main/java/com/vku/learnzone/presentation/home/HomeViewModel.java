package com.vku.learnzone.presentation.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.AssignmentApi;
import com.vku.learnzone.data.remote.CourseApi;
import com.vku.learnzone.presentation.home.model.Assignments;
import com.vku.learnzone.presentation.courses.model.Course;
import com.vku.learnzone.presentation.home.model.RecentlyCourses;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mNumberAssignmentToday;
    private MutableLiveData<RecentlyCourses> recentlyCoursesMutableLiveData;
    private MutableLiveData<Assignments> assignmentsMutableLiveData;

    public LiveData<String> getNumberAssignmentToday(String accessToken) {
        if (mNumberAssignmentToday == null) {
            mNumberAssignmentToday = new MutableLiveData<>();
            loadNumberAssignmentToday(accessToken);
        }
        return mNumberAssignmentToday;
    }


    private void loadNumberAssignmentToday(String accessToken) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        AssignmentApi assignmentApi = retrofit.create(AssignmentApi.class);
        Call<String> call = assignmentApi.numberOfAssignmentToday();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mNumberAssignmentToday.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mNumberAssignmentToday.setValue(t.getMessage());
            }
        });
    }

    // ===============================================
    public LiveData<RecentlyCourses> getRecentlyCourses(String accessToken) {
        if (recentlyCoursesMutableLiveData == null) {
            recentlyCoursesMutableLiveData = new MutableLiveData<>();
            loadRecentlyCourses(accessToken);
        }
        return recentlyCoursesMutableLiveData;
    }


    private void loadRecentlyCourses(String accessToken) {
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

        CourseApi courseApi = retrofit.create(CourseApi.class);
        Call<RecentlyCourses> call = courseApi.getRecentlyCourses();

        call.enqueue(new Callback<RecentlyCourses>() {
            @Override
            public void onResponse(Call<RecentlyCourses> call, Response<RecentlyCourses> response) {
                recentlyCoursesMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RecentlyCourses> call, Throwable t) {

            }
        });
    }

    // ===================================================
    public LiveData<Assignments> getAllAssignmentsMini(String accessToken) {
        if (assignmentsMutableLiveData == null) {
            assignmentsMutableLiveData = new MutableLiveData<>();
            loadAllAssignmentsMini(accessToken);
        }
        return assignmentsMutableLiveData;
    }


    private void loadAllAssignmentsMini(String accessToken) {
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

        AssignmentApi assignmentApi = retrofit.create(AssignmentApi.class);
        Call<Assignments> call = assignmentApi.getAllAssignmentsMini();


        call.enqueue(new Callback<Assignments>() {
            @Override
            public void onResponse(Call<Assignments> call, Response<Assignments> response) {
                assignmentsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Assignments> call, Throwable t) {

            }
        });
    }
}
