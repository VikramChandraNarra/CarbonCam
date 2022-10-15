package com.example.carboncam;

import android.graphics.Bitmap;

public class Post {
    String author, description;
    int carbon;
    Bitmap postpic;

    public Post(String author, String description, int carbon, Bitmap postpic) {
        this.author = author;
        this.description = description;
        this.carbon = carbon;
        this.postpic = postpic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getcarbon() {
        return carbon;
    }

    public void setcarbon(int carbon) {
        this.carbon = carbon;
    }

    public Bitmap getPostpic() {
        return postpic;
    }

    public void setPostpic(Bitmap postpic) {
        this.postpic = postpic;
    }
}
