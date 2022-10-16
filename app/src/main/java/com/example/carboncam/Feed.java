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
    Button camera,  profile,  list;
    Bitmap bm;
    private RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        recyclerView2 = findViewById(R.id.recycler_view2);
        camera = findViewById(R.id.camera_feed);
        profile = findViewById(R.id.profile_feed);
        list = findViewById(R.id.list_feed);
//        imageview = findViewById(R.id.image_view);
//        btopen2 = findViewById(R.id.bt2);
//
        if (ContextCompat.checkSelfPermission(Feed.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Feed.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feed.this, MainActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feed.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feed.this, CameraActivity.class);
                startActivity(intent);
            }
        });

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
        posts.add(new Post("Vikram Narra", "Waterbottle :)", 100, null));
        posts.add(new Post("Divyansh", "Wrapper :/", 110, null));
        posts.add(new Post("Haris", "Paper Paper", 90, null));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                Bitmap captureImage = (Bitmap) data.getExtras().get("data");
                // Here is where you inputting the values of the ML algorihtm, from extrapolatign the data
                ScannedItem scanned = new ScannedItem("", 2, captureImage);
                Post o = new Post("hello", "pp", 4, captureImage);
                posts.add(o);
                System.out.println("haris");
                setAdapter();
                Intent intent = new Intent(Feed.this, IndividualPicture.class);
                intent.putExtra("captureImage", captureImage);
                intent.putExtra("title", scanned.getTitle());

                intent.putExtra("carbon", scanned.getScore());

                startActivity(intent);
            }



//            imageview.setImageBitmap(captureImage);
        }
    }

}
