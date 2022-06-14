package com.vku.learnzone.presentation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vku.learnzone.R;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.presentation.courses.model.Course;
import com.vku.learnzone.presentation.course_detail.CourseDetailScreen;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private final ArrayList<Course> courses;

    private final Context context;

    public CourseAdapter(ArrayList<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        Picasso.get().load(Constants.HOST_BASE_URL + course.getCourseCover()).into(holder.image);
        holder.tvName.setText(course.getCourseTitle());
        holder.tvAssignment.setText(String.format("%d assignments", course.getNumberOfAssignments()));
        holder.tvTeacher.setText(course.getTeacherName());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CourseDetailScreen.class);
            intent.putExtra("courseId", course.course_id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courses == null ? 0 : courses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvName, tvAssignment, tvTeacher;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.course_image);
            tvName = itemView.findViewById(R.id.course_name);
            tvAssignment = itemView.findViewById(R.id.course_assignment);
            tvTeacher = itemView.findViewById(R.id.course_teacher);
        }
    }
}

