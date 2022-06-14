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
import com.vku.learnzone.presentation.post_detail.model.Comment;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<Comment> comments;

    private Context context;

    public CommentAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new CommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        Picasso.get().load(Constants.HOST_BASE_URL + comment.getAuthorAvatar()).into(holder.image);
        holder.tvName.setText(comment.getAuthorName());
        holder.tvContent.setText(comment.getContent());
        holder.tvTime.setText(comment.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return comments == null ? 0 : comments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvName, tvTime, tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.comment_author_avatar);
            tvName = itemView.findViewById(R.id.comment_author_name);
            tvTime = itemView.findViewById(R.id.comment_time);
            tvContent = itemView.findViewById(R.id.comment_content);
        }
    }
}
