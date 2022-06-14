package com.vku.learnzone.presentation.courses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.CourseApi;
import com.vku.learnzone.presentation.courses.model.Courses;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesViewModel extends ViewModel {
    private MutableLiveData<Courses> coursesMutableLiveData;

    public LiveData<Courses> getAllCourses(String accessToken) {
        if (coursesMutableLiveData == null) {
            coursesMutableLiveData = new MutableLiveData<>();
            loadAllCourses(accessToken);
        }
        return coursesMutableLiveData;
    }

    private void loadAllCourses(String accessToken) {
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
        Call<Courses> call = courseApi.getAllCourses();

        call.enqueue(new Callback<Courses>() {
            @Override
            public void onResponse(Call<Courses> call, Response<Courses> response) {
                coursesMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Courses> call, Throwable t) {

            }
        });
    }
}
