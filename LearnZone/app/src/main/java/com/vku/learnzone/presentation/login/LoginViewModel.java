package com.vku.learnzone.presentation.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vku.learnzone.common.Constants;
import com.vku.learnzone.data.remote.AuthApi;
import com.vku.learnzone.presentation.login.model.LoginRequest;
import com.vku.learnzone.presentation.login.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginResponse> mLoginResponse;

    public LiveData<LoginResponse> login(LoginRequest loginRequest) {
        if (mLoginResponse == null) {
            mLoginResponse = new MutableLiveData<LoginResponse>();
            loadLogin(loginRequest);
        }
        return mLoginResponse;
    }

    private void loadLogin(LoginRequest loginRequest) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthApi apiService = retrofit.create(AuthApi.class);
        Call<LoginResponse> call = apiService.login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                mLoginResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
