package com.vku.learnzone.presentation.forum;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vku.learnzone.databinding.FragmentForumBinding;
import com.vku.learnzone.presentation.create_post.CreatePostScreen;
import com.vku.learnzone.presentation.forum.model.Post;
import com.vku.learnzone.presentation.forum.model.Posts;
import com.vku.learnzone.presentation.adapter.PostAdapter;

import java.util.ArrayList;

public class ForumFragment extends Fragment {

    private ArrayList<Post> postArrayList;
    FragmentForumBinding binding;

    public ForumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForumBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ForumViewModel model = new ForumViewModel();
        postArrayList = new ArrayList<>();
        model.getPosts().observe(getViewLifecycleOwner(), new Observer<Posts>() {
            @Override
            public void onChanged(Posts posts) {
                RecyclerView recyclerView = binding.forumRecycler;
                postArrayList = (ArrayList<Post>) posts.getPosts();
                PostAdapter adapter = new PostAdapter(postArrayList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }
        });

        binding.btnCreatePost.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), CreatePostScreen.class));
        });
    }
}