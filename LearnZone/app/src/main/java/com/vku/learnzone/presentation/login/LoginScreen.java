package com.vku.learnzone.presentation.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vku.learnzone.LearnZoneApplication;
import com.vku.learnzone.R;
import com.vku.learnzone.presentation.login.model.LoginRequest;
import com.vku.learnzone.presentation.login.model.LoginResponse;

public class LoginScreen extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail, edtPassword;
    TextView tvResult;
    LoginViewModel model;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        init();
        LoginRequest loginRequest = new LoginRequest();
        btnLogin.setOnClickListener(view -> {
            loginRequest.setEmail(edtEmail.getText().toString());
            loginRequest.setPassword(edtPassword.getText().toString());
            model.login(loginRequest).observe(this, new Observer<LoginResponse>() {
                @Override
                public void onChanged(LoginResponse loginResponse) {
                    if (!loginResponse.access_token.isEmpty()) {
                        SharedPreferences sharedPreferences = LoginScreen.this.getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("access_token", loginResponse.access_token);
                        editor.putString("name", loginResponse.user.getName());
                        if (loginResponse.user.getAvatar() != null) {
                            editor.putString("avatar", loginResponse.user.getAvatar().toString());
                        }
                        editor.putString("email", loginResponse.user.getEmail());
                        editor.commit();
                        startActivity(new Intent(LoginScreen.this, LearnZoneApplication.class));
                        finish();
                    }

                }
            });
        });
    }

    private void init() {
        model = new LoginViewModel();
        btnLogin = findViewById(R.id.btn_login);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvResult = findViewById(R.id.tv_result);
        sharedPreferences = LoginScreen.this.getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString("access_token", "");

        if (!accessToken.isEmpty()) {
            startActivity(new Intent(this, LearnZoneApplication.class));
            finish();
        }
    }
}