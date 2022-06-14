package com.vku.learnzone.presentation.course_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.squareup.picasso.Picasso;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.databinding.CourseDetailScreenBinding;
import com.vku.learnzone.presentation.adapter.AssignmentInCourseAdapter;
import com.vku.learnzone.presentation.adapter.MaterialAdapter;
import com.vku.learnzone.presentation.course_detail.model.Assignment;
import com.vku.learnzone.presentation.course_detail.model.Assignments;
import com.vku.learnzone.presentation.course_detail.model.CourseResponse;
import com.vku.learnzone.presentation.course_detail.model.Material;
import com.vku.learnzone.presentation.course_detail.model.Materials;

import java.util.ArrayList;

public class CourseDetailScreen extends AppCompatActivity {

    CourseDetailScreenBinding binding;
    private CourseResponse mCourse;
    private ArrayList<Assignment> assignmentArrayList;
    private ArrayList<Material> materialArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CourseDetailScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mCourse = new CourseResponse();
        assignmentArrayList = new ArrayList<>();
        SharedPreferences sharedPreferences = this.getSharedPreferences("LearnZonePref", Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString("access_token", "");
        Intent intent = getIntent();
        int courseId = intent.getIntExtra("courseId", 0);
        CourseDetailViewModel courseDetailViewModel = new CourseDetailViewModel();
        courseDetailViewModel.getCourseInfo(accessToken, courseId).observe(this, new Observer<CourseResponse>() {
            @Override
            public void onChanged(CourseResponse course) {
                mCourse = course;
                binding.courseName.setText(mCourse.getCourse().courseTitle);
                Picasso.get().load(Constants.HOST_BASE_URL + mCourse.getCourse().getCourseCover()).into(binding.courseCover);
                Picasso.get().load(Constants.HOST_BASE_URL + mCourse.getCourse().getTeacherAvatar()).into(binding.courseTeacherAvatar);
                binding.courseTeacherName.setText(mCourse.getCourse().teacherName);
                binding.courseDescription.setText(mCourse.getCourse().getCourseIntroduction());
            }
        });
        courseDetailViewModel.getAssignmentsOfCourse(accessToken, courseId).observe(this, new Observer<Assignments>() {
            @Override
            public void onChanged(Assignments assignmentResponse) {
                assignmentArrayList = assignmentResponse.getAssignments();
                RecyclerView recyclerView = binding.assignmentRecycler;
                AssignmentInCourseAdapter adapter = new AssignmentInCourseAdapter(assignmentArrayList, CourseDetailScreen.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(CourseDetailScreen.this, LinearLayoutManager.HORIZONTAL, false));
            }
        });

        courseDetailViewModel.getMaterialsInCourse(accessToken, courseId).observe(this, new Observer<Materials>() {
            @Override
            public void onChanged(Materials materials) {
                materialArrayList = materials.getMaterials();
                RecyclerView recyclerView = binding.materialRecycler;
                MaterialAdapter adapter = new MaterialAdapter(materialArrayList, CourseDetailScreen.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(CourseDetailScreen.this, LinearLayoutManager.HORIZONTAL, false));
            }
        });

    }

}