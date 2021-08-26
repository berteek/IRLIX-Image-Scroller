package com.example.irlix_image_scroller;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(tableName = "image_block_table")
final class ImageBlock {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String imageURL;
    private String userName;
    private String userProfilePictureURL;
    private String tags;
    private int likes;

    public ImageBlock(String imageURL, String userName, String userProfilePictureURL, String tags, int likes) {
        this.imageURL = imageURL;
        this.userName = userName;
        this.userProfilePictureURL = userProfilePictureURL;
        this.tags = tags;
        this.likes = likes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserProfilePictureURL() {
        return userProfilePictureURL;
    }

    public String getTags() {
        return tags;
    }

    public int getLikes() {
        return likes;
    }
}
