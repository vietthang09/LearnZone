package com.vku.learnzone.presentation.post_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.squareup.picasso.Picasso;
import com.vku.learnzone.R;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.databinding.PostDetailScreenBinding;
import com.vku.learnzone.presentation.adapter.AssignmentInCourseAdapter;
import com.vku.learnzone.presentation.adapter.CommentAdapter;
import com.vku.learnzone.presentation.course_detail.CourseDetailScreen;
import com.vku.learnzone.presentation.post_detail.model.Comment;
import com.vku.learnzone.presentation.post_detail.model.CommentResponse;
import com.vku.learnzone.presentation.post_detail.model.Comments;
import com.vku.learnzone.presentation.post_detail.model.PostResponse;

import java.util.ArrayList;

public class PostDetailScreen extends AppCompatActivity {

    PostDetailScreenBinding binding;
    private PostResponse post;
    private ArrayList<Comment> commentArrayList;
    PostDetailViewModel postDetailViewModel;
    String accessToken;
    int postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PostDetailScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = this.getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("access_token", "");
        commentArrayList = new ArrayList<>();
        Intent intent = getIntent();
        postId = intent.getIntExtra("postId", 0);

        postDetailViewModel = new PostDetailViewModel();
        postDetailViewModel.getPost(accessToken, postId).observe(this, new Observer<PostResponse>() {
            @Override
            public void onChanged(PostResponse postResponse) {
                post = postResponse;
                Picasso.get().load(Constants.HOST_BASE_URL + post.getPost().getImage()).into(binding.postImage);
                Picasso.get().load(Constants.HOST_BASE_URL + post.getPost().getAuthorAvatar()).into(binding.postAuthorAvatar);
                binding.postAuthorName.setText(post.getPost().getAuthorName());
                binding.postContent.setText(post.getPost().getContent());
                binding.postTime.setText(post.getPost().getCreatedAt());
            }
        });


        postDetailViewModel.getComments(accessToken, postId).observe(this, new Observer<Comments>() {
            @Override
            public void onChanged(Comments comments) {
                commentArrayList = comments.getComments();
                RecyclerView recyclerView = binding.commentRecycler;
                CommentAdapter adapter = new CommentAdapter(commentArrayList, PostDetailScreen.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(PostDetailScreen.this, LinearLayoutManager.VERTICAL, false));

            }
        });

        binding.btnPost.setOnClickListener(view -> {
            String comment_content = binding.edtComment.getText().toString();
            postDetailViewModel.create(accessToken, postId, comment_content).observe(this, new Observer<CommentResponse>() {
                @Override
                public void onChanged(CommentResponse commentResponse) {
                    finish();
                    startActivity(getIntent());
                }
            });
        });

    }

}