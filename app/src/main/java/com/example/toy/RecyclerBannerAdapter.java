package com.example.toy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerBannerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RecyclerBannerItem> bannerItems;

    public RecyclerBannerAdapter(Context context, ArrayList<RecyclerBannerItem> bannerItems) {
        this.context = context;
        this.bannerItems = bannerItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_banner_item, parent, false);
        VH vh = new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;
        RecyclerBannerItem item = bannerItems.get(position);
        Glide.with(context).load(item.img).into(vh.img);

    }

    @Override
    public int getItemCount() {
        return bannerItems.size();
    }

    class VH extends RecyclerView.ViewHolder {

        ImageView img;

        public VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.banner);
        }
    }
}
