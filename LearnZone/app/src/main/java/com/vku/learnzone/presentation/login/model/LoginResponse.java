package com.vku.learnzone.presentation.login.model;

import com.vku.learnzone.domain.model.User;

public class LoginResponse {
    public String access_token;
    public String token_type;
    public int expires_in;
    public User user;
}
