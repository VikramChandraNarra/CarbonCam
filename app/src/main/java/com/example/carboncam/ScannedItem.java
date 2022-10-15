package com.example.carboncam;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ScannedItem {
    String title;
    int score;
    Bitmap imageView;


    public ScannedItem(String title, int score, Bitmap imageView) {
        this.title = title;
        this.score = score;
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Bitmap getImageView() {
        return imageView;
    }

    public void setImageView(Bitmap imageView) {
        this.imageView = imageView;
    }
}
