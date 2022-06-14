package com.vku.learnzone.presentation.adapter;

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
import com.vku.learnzone.presentation.course_detail.CourseDetailScreen;
import com.vku.learnzone.presentation.courses.model.Course;
import com.vku.learnzone.presentation.home.model.RecentlyCourse;

import java.util.ArrayList;

public class RecentlyCourseAdapter extends RecyclerView.Adapter<RecentlyCourseAdapter.ViewHolder> {

    private ArrayList<RecentlyCourse> recentlyCourses;

    private Context context;

    public RecentlyCourseAdapter(ArrayList<RecentlyCourse> recentlyCourses, Context context) {
        this.recentlyCourses = recentlyCourses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecentlyCourse course = recentlyCourses.get(position);
        Picasso.get().load(Constants.HOST_BASE_URL + course.getCourseCover()).into(holder.image);
        holder.tvName.setText(course.getCourseTitle());
        holder.tvAssignment.setText(course.getNumberOfAssignments() + " assignments");
        holder.tvTeacher.setText(course.getTeacherName());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CourseDetailScreen.class);
            intent.putExtra("courseId", course.getCourse_id());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recentlyCourses == null ? 0 : recentlyCourses.size();
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

