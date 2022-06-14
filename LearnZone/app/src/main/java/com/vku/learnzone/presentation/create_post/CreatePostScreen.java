package com.vku.learnzone.presentation.create_post;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.vku.learnzone.R;
import com.vku.learnzone.databinding.CreatePostScreenBinding;
import com.vku.learnzone.presentation.create_post.model.CreatePost_Request;
import com.vku.learnzone.presentation.create_post.model.CreatePost_Response;
import com.vku.learnzone.presentation.forum.ForumFragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CreatePostScreen extends AppCompatActivity {

    CreatePostScreenBinding binding;
    Uri selectedImageUri;
    String accessToken;

    Bitmap selectedImageBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CreatePostScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = this.getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("access_token", "");

        binding.btnAddImage.setOnClickListener(view -> {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            launchSomeActivity.launch(i);
        });

        binding.btnCreatePost.setOnClickListener(view -> {
            String content = binding.postContent.getText().toString();
            CreatePostViewModel viewModel = new CreatePostViewModel();
            CreatePost_Request post = new CreatePost_Request(content);
            viewModel.createPost(accessToken, post).observe(this, new Observer<CreatePost_Response>() {
                @Override
                public void onChanged(CreatePost_Response createPost_response) {
                    if (createPost_response.getStatus()) {
                        CreatePostScreen.super.onBackPressed();
                    }
                }
            });
        });
    }

    ActivityResultLauncher<Intent> launchSomeActivity
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        selectedImageUri = data.getData();
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    this.getContentResolver(),
                                    selectedImageUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        binding.postImagePreview.setImageBitmap(selectedImageBitmap);
                    }
                }
            });
}