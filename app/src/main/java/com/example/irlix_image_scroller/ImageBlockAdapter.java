package com.example.irlix_image_scroller;

import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.irlix_image_scroller.databinding.ImageBlockBinding;

import java.util.List;

public class ImageBlockAdapter extends RecyclerView.Adapter<ImageBlockAdapter.ImageBlockHolder> {

    List<ImageBlock> imageBlockList;

    @Override
    public ImageBlockHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_block, parent, false);
        return new ImageBlockHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageBlockAdapter.ImageBlockHolder holder, int position) {
        holder.bind(imageBlockList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageBlockList.size();
    }

    public void addImageBlock(ImageBlock imageBlock) {
        imageBlockList.add(imageBlock);
        notifyDataSetChanged();
    }

    class ImageBlockHolder extends RecyclerView.ViewHolder {

        ImageBlockBinding imageBlockBinding;

        public ImageBlockHolder(View item) {
            super(item);
            imageBlockBinding = ImageBlockBinding.bind(item);
        }

        public void bind(ImageBlock imageBlock) {
            Glide.with(imageBlockBinding.cardView)
                    .load(imageBlock.imageURL)
                    .into(imageBlockBinding.imageView);
            imageBlockBinding.userNameView.setText(imageBlock.userName);
            imageBlockBinding.likesTextView.setText(imageBlock.likes);
            String tagsConverted = TextUtils.join(", ", imageBlock.tags);
            imageBlockBinding.tagsView.setText(tagsConverted);
            Glide.with(imageBlockBinding.cardView)
                    .load(imageBlock.userProfilePictureURL)
                    .into(imageBlockBinding.userProfilePictureView);
        }
    }
}
