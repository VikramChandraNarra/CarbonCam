package com.example.carboncam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {
    ArrayList<Post> posts = new ArrayList<Post>();

    //    ImageView imageview;
    Button btopen2;
    Bitmap bm;
    private RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        recyclerView2 = findViewById(R.id.recycler_view2);

//        imageview = findViewById(R.id.image_view);
//        btopen2 = findViewById(R.id.bt2);
//
//        if (ContextCompat.checkSelfPermission(Feed.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(Feed.this,
//                    new String[]{
//                            Manifest.permission.CAMERA
//                    },
//                    100);
//        }
//
//        btopen2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, 0);
//            }
//        });

        setUserInfo();
        setAdapter();
    }

    private void setAdapter(){
        FeedAdapter adapter = new FeedAdapter(posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter);
    }

    private void setUserInfo(){
        posts.add(new Post("eee", "I'm dead", 100, bm));
        posts.add(new Post("eee", "I'm dead2", 100, bm));
        posts.add(new Post("eee", "I'm dead3", 100, bm));

    }


}
