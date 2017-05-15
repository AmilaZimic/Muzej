package com.example.dana.muzej.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dana.muzej.Helpers.Image;
import com.example.dana.muzej.Helpers.News;
import com.example.dana.muzej.R;

import java.util.Locale;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mAdImage1;
    private TextView mAdName1;

    public NewsViewHolder(View itemView) {
        super(itemView);
        mAdImage1 = (ImageView) itemView.findViewById(R.id.news_image);
        mAdName1 = (TextView) itemView.findViewById(R.id.news_name);
    }

    public void bindAd(News ad) {
        if(Locale.getDefault().getLanguage().equals("hr"))
        {
            mAdName1.setText(ad.event_name_bih);
        }
        else
        {
            mAdName1.setText(ad.event_name_eng);
        }
        Glide.with(mAdImage1.getContext()).load(ad.event_image).into(mAdImage1);
    }

}

