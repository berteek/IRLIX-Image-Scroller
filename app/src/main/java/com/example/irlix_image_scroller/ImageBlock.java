package com.example.irlix_image_scroller;

import java.util.ArrayList;
import java.util.List;

final class ImageBlock {

    String imageURL;
    String userName;
    String userProfilePictureURL;
    ArrayList<String> tags;
    int likes;

    public ImageBlock(String imageURL, String userName, String userProfilePictureURL, ArrayList<String> tags, int likes) {
        this.imageURL = imageURL;
        this.userName = userName;
        this.userProfilePictureURL = userProfilePictureURL;
        this.tags = tags;
        this.likes = likes;
    }
}
