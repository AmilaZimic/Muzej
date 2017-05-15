package com.example.dana.muzej.Helpers;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dana.muzej.R;
import com.example.dana.muzej.ViewHolders.ImageDetails;
import com.example.dana.muzej.ViewHolders.NewsDetails;
import com.example.dana.muzej.ViewHolders.NewsViewHolder;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    ArrayList<News> m1Images;



    public NewsAdapter(ArrayList<News> mAds)
    {
        this.m1Images = mAds;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(inflatedView);
    }

    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final News image1 = m1Images.get(position);
        holder.bindAd(image1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Hello", Toast.LENGTH_SHORT).show();
                //Open New Activity show details about advertisment
                Intent intent = new Intent(view.getContext(), NewsDetails.class);
                intent.putExtra("ad",image1);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return m1Images.size();
    }
}

