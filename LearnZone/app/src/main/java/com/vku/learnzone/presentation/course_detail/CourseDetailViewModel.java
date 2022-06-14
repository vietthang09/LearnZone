package com.vku.learnzone.presentation.course_detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.AssignmentApi;
import com.vku.learnzone.data.remote.CourseApi;
import com.vku.learnzone.data.remote.MaterialApi;
import com.vku.learnzone.presentation.course_detail.model.Assignment;
import com.vku.learnzone.presentation.course_detail.model.Assignments;
import com.vku.learnzone.presentation.course_detail.model.CourseRequestBody;
import com.vku.learnzone.presentation.course_detail.model.CourseResponse;
import com.vku.learnzone.presentation.course_detail.model.Materials;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CourseDetailViewModel extends ViewModel {
    private MutableLiveData<CourseResponse> courseMutableLiveData;
    private MutableLiveData<Assignments> assignmentResponseMutableLiveData;
    private MutableLiveData<Materials> materialsMutableLiveData;

    public LiveData<CourseResponse> getCourseInfo(String accessToken, int id) {
        if (courseMutableLiveData == null) {
            courseMutableLiveData = new MutableLiveData<>();
            loadCourseInfo(accessToken, id);
        }
        return courseMutableLiveData;
    }

    private void loadCourseInfo(String accessToken, int id) {
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

        CourseApi courseApi = retrofit.create(CourseApi.class);
        Call<CourseResponse> call = courseApi.getCourseInfo(new CourseRequestBody(id));

        call.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, retrofit2.Response<CourseResponse> response) {
                courseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });
    }

    // ==================================================

    public LiveData<Assignments> getAssignmentsOfCourse(String accessToken, int id) {
        if (assignmentResponseMutableLiveData == null) {
            assignmentResponseMutableLiveData = new MutableLiveData<>();
            loadAssignmentsOfCourse(accessToken, id);
        }
        return assignmentResponseMutableLiveData;
    }

    private void loadAssignmentsOfCourse(String accessToken, int id) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build();
                return chain.          proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        AssignmentApi assignmentApi = retrofit.create(AssignmentApi.class);
        Call<Assignments> call = assignmentApi.getAssignmentsOfCourse(new CourseRequestBody(id));

        call.enqueue(new Callback<Assignments>() {
            @Override
            public void onResponse(Call<Assignments> call, retrofit2.Response<Assignments> response) {
                assignmentResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Assignments> call, Throwable t) {

            }
        });
    }

    // =====================================
    public LiveData<Materials> getMaterialsInCourse(String accessToken, int id) {
        if (materialsMutableLiveData == null) {
            materialsMutableLiveData = new MutableLiveData<>();
            loadMaterialsInCourse(accessToken, id);
        }
        return materialsMutableLiveData;
    }

    private void loadMaterialsInCourse(String accessToken, int id) {
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

        MaterialApi materialApi = retrofit.create(MaterialApi.class);
        Call<Materials> call = materialApi.getMaterialsInCourse(new CourseRequestBody(id));

       call.enqueue(new Callback<Materials>() {
           @Override
           public void onResponse(Call<Materials> call, Response<Materials> response) {
               materialsMutableLiveData.setValue(response.body());
           }

           @Override
           public void onFailure(Call<Materials> call, Throwable t) {

           }
       });
    }
}
