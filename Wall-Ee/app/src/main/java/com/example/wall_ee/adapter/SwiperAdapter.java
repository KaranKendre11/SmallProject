package com.example.wall_ee.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.wall_ee.R;
import com.example.wall_ee.model.WallpaperModel;

import java.util.List;
import java.util.Random;

public class SwiperAdapter extends RecyclerView.Adapter<SwiperAdapter.SwiperHolder> {

    Context context;
    private List<WallpaperModel > list;

    public SwiperAdapter(List<WallpaperModel> list) {
        this.list = list;
    }

    public SwiperAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SwiperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_item,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SwiperHolder holder, int position) {
        Random random = new Random();

        int color = Color.argb(255,
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        holder.constraintLayout.setBackgroundColor(color);

        Glide.with(context.getApplicationContext()).load(list.get(position).getImage())
        .timeout(6500)
        .listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.constraintLayout.setBackgroundColor(Color.TRANSPARENT);
                return false;
            }
        })
        .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class SwiperHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private ConstraintLayout constraintLayout;


        public SwiperHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            constraintLayout = itemView.findViewById(R.id.consLayout);
        }
    }
}
