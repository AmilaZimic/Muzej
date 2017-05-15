package com.example.dana.muzej.Helpers;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dana.muzej.R;
import com.example.dana.muzej.ViewHolders.ImageDetails;
import com.example.dana.muzej.ViewHolders.ImageViewHolder;

import java.util.ArrayList;

/**
 * Created by Džana on 18.1.2017.
 */

public  class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    ArrayList<Image> mImages;



    public ImageAdapter(ArrayList<Image> mAds)
    {
        this.mImages = mAds;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(inflatedView);
    }

    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final Image image = mImages.get(position);
        holder.bindAd(image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Hello", Toast.LENGTH_SHORT).show();
                //Open New Activity show details about advertisment
                Intent intent = new Intent(view.getContext(), ImageDetails.class);
                intent.putExtra("ad",image);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }
}

