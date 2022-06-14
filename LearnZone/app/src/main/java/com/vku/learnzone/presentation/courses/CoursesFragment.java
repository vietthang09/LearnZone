package com.vku.learnzone.presentation.courses;

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

import com.vku.learnzone.databinding.FragmentCoursesBinding;
import com.vku.learnzone.presentation.courses.model.Course;
import com.vku.learnzone.presentation.courses.model.Courses;
import com.vku.learnzone.presentation.adapter.CourseAdapter;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    FragmentCoursesBinding binding;
    private ArrayList<Course> courseArrayList;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        courseArrayList = new ArrayList<>();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString("access_token", "");

        CoursesViewModel coursesViewModel = new CoursesViewModel();
        coursesViewModel.getAllCourses(accessToken).observe(getViewLifecycleOwner(), new Observer<Courses>() {
            @Override
            public void onChanged(Courses courses) {
                RecyclerView recyclerView = binding.recyclerCourses;
                courseArrayList = courses.getCourses();
                CourseAdapter adapter = new CourseAdapter(courseArrayList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }
        });
    }
}