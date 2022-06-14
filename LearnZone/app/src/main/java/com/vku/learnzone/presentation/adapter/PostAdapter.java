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
import com.vku.learnzone.presentation.forum.model.Post;
import com.vku.learnzone.presentation.post_detail.PostDetailScreen;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> posts;
    private Context context;

    public PostAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        Picasso.get().load(Constants.HOST_BASE_URL + post.getAuthorAvatar()).into(holder.avatar);
        if (post.getFilePath() != null) {
            Picasso.get().load(Constants.HOST_BASE_URL + post.getFilePath()).into(holder.image);
            holder.image.setVisibility(View.VISIBLE);
        }
        holder.tvAuthor.setText(post.getAuthorName());
        holder.tvTime.setText(post.getCreatedAt());
        holder.tvContent.setText(post.getContent());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, PostDetailScreen.class);
            intent.putExtra("postId", post.getPostId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, avatar;
        TextView tvAuthor, tvTime, tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.post_image);
            avatar = itemView.findViewById(R.id.post_author_avatar);
            tvAuthor = itemView.findViewById(R.id.post_author_name);
            tvTime = itemView.findViewById(R.id.post_time);
            tvContent = itemView.findViewById(R.id.post_content);
        }
    }
}
