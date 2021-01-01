package com.example.wall_ee.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wall_ee.R;
import com.example.wall_ee.SwiperActivity;
import com.example.wall_ee.model.WallpaperModel;

import java.util.List;
import java.util.Random;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder> {

  private List<WallpaperModel> list;

    public WallpaperAdapter(List<WallpaperModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_items,parent,false);
        return new WallpaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperHolder holder, int position) {

        Random random = new Random();
        int color = Color.argb(225,
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));

        Glide.with(holder.itemView.getContext().getApplicationContext()).load(list.get(position).getImage())
                .timeout(7500)
                .placeholder(new ColorDrawable(color))
                .into(holder.imageView);

        holder.setClickListener();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class WallpaperHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public WallpaperHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }

        private void setClickListener(){
            // set on click listener on wallpaper image

                itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position = getAdapterPosition();
                            Intent intent = new Intent(itemView.getContext().getApplicationContext(), SwiperActivity.class);

                            intent.putExtra("position",position);
                            itemView.getContext().startActivity(intent);

                        }

                });

        }

    }
}
