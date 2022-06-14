package com.vku.learnzone.presentation.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.vku.learnzone.R;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.databinding.FragmentProfileBinding;
import com.vku.learnzone.presentation.login.LoginScreen;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);

        Picasso.get().load(Constants.HOST_BASE_URL + sharedPreferences.getString("avatar", "")).into(binding.userAvatar);

        binding.userName.setText(sharedPreferences.getString("name", ""));
        binding.userEmail.setText(sharedPreferences.getString("email", ""));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        binding.btnLogout.setOnClickListener(v -> {
            editor.clear();
            editor.commit();
            startActivity(new Intent(getContext(), LoginScreen.class));
        });


    }
}