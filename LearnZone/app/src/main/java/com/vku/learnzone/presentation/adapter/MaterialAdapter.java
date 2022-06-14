package com.vku.learnzone.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vku.learnzone.R;
import com.vku.learnzone.common.Constants;
import com.vku.learnzone.presentation.course_detail.model.Material;

import java.util.ArrayList;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.ViewHolder> {

    private ArrayList<Material> materials;
    private Context context;

    public MaterialAdapter(ArrayList<Material> materials, Context context) {
        this.materials = materials;
        this.context = context;
    }

    @NonNull
    @Override
    public MaterialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        return new MaterialAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialAdapter.ViewHolder holder, int position) {
        Material material = materials.get(position);
        holder.tvName.setText(material.getMaterialTitle());
        holder.tvContent.setText(material.getMaterialContent());
        holder.itemView.setOnClickListener(view -> {
            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.API_BASE_URL + "material/download/" + material.getMaterialId()));
            context.startActivity(browse);
        });

    }

    @Override
    public int getItemCount() {
        return materials == null ? 0 : materials.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView btnDownload;
        TextView tvName, tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.material_name);
            tvContent = itemView.findViewById(R.id.material_content);
        }
    }
}
