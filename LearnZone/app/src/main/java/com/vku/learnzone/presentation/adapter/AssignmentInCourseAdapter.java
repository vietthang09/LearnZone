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
import com.vku.learnzone.presentation.course_detail.model.Assignment;

import java.util.ArrayList;

public class AssignmentInCourseAdapter extends RecyclerView.Adapter<AssignmentInCourseAdapter.ViewHolder> {

    private ArrayList<Assignment> assignments;
    private Context context;

    public AssignmentInCourseAdapter(ArrayList<Assignment> assignments, Context context) {
        this.assignments = assignments;
        this.context = context;
    }

    @NonNull
    @Override
    public AssignmentInCourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_item, parent, false);
        return new AssignmentInCourseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentInCourseAdapter.ViewHolder holder, int position) {
        Assignment assignment = assignments.get(position);
        Picasso.get().load(Constants.HOST_BASE_URL + assignment.getTeacherAvatar()).into(holder.image);
        holder.tvAuthor.setText(assignment.getAssignmentTitle());
        holder.tvCourse.setText("In: " + assignment.getCourseTitle());
        holder.tvDeadline.setText("Deadline: " + assignment.getDeadline());
    }

    @Override
    public int getItemCount() {
        return assignments == null ? 0 : assignments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvAuthor, tvCourse, tvDeadline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.assignment_teacher);
            tvAuthor = itemView.findViewById(R.id.assignment_name);
            tvCourse = itemView.findViewById(R.id.assignment_course);
            tvDeadline = itemView.findViewById(R.id.assignment_deadline);
        }
    }
}
