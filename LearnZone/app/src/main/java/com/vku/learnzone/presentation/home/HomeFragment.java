package com.vku.learnzone.presentation.home;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.vku.learnzone.presentation.adapter.RecentlyCourseAdapter;
import com.vku.learnzone.presentation.home.model.Assignment;
import com.vku.learnzone.presentation.home.model.Assignments;
import com.vku.learnzone.presentation.courses.model.Course;
import com.vku.learnzone.databinding.FragmentHomeBinding;
import com.vku.learnzone.presentation.adapter.AssignmentAdapter;
import com.vku.learnzone.presentation.adapter.CourseAdapter;
import com.vku.learnzone.presentation.home.model.RecentlyCourse;
import com.vku.learnzone.presentation.home.model.RecentlyCourses;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    private ArrayList<Assignment> assignments;
    private ArrayList<RecentlyCourse> recentlyCourseArrayList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recentlyCourseArrayList = new ArrayList<>();
        assignments = new ArrayList<>();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String accessToken = sharedPreferences.getString("access_token", "");

        binding.tvGreeting.setText("Hi " + name + " !");
        HomeViewModel model = new HomeViewModel();
        model.getNumberAssignmentToday(accessToken).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s == null) {
                    binding.tvNumberOfAssignments.setText("There are no today");
                } else {
                    binding.tvNumberOfAssignments.setText("There are " + s + " today");
                }
            }
        });
        model.getRecentlyCourses(accessToken).observe(getViewLifecycleOwner(), new Observer<RecentlyCourses>() {
            @Override
            public void onChanged(RecentlyCourses recentlyCourses) {
                RecyclerView recyclerView = binding.recyclerCourses;
                recentlyCourseArrayList = recentlyCourses.getRecentlyCourses();
                RecentlyCourseAdapter adapter = new RecentlyCourseAdapter(recentlyCourseArrayList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

            }
        });

        model.getAllAssignmentsMini(accessToken).observe(getViewLifecycleOwner(), new Observer<Assignments>() {
            @Override
            public void onChanged(Assignments as) {
                RecyclerView recyclerView = binding.recyclerAssignments;
                assignments = as.getAssignments();
                AssignmentAdapter adapter = new AssignmentAdapter(assignments, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }
        });

    }
}