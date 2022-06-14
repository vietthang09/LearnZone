package com.vku.learnzone.data.remote;

import com.vku.learnzone.presentation.login.model.LoginRequest;
import com.vku.learnzone.presentation.login.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
