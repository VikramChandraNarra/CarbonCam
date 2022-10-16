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

public class MainActivity extends AppCompatActivity {

    ArrayList<ScannedItem> objects = new ArrayList<ScannedItem>();

//    ImageView imageview;
    Button btopen;
    Button feedbtn;
    Bitmap bm;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

//        imageview = findViewById(R.id.image_view);
        btopen = findViewById(R.id.bt_open);
        feedbtn = findViewById(R.id.profile);


        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }

        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent i = new Intent(MainActivity.this, Popup.class);
                startActivity(i);
                startActivityForResult(intent, 0);
            }
        });
        feedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Feed.class);
                startActivity(intent);
            }
        });

        setUserInfo();
        setAdapter();
    }

    private void setAdapter(){
        MyAdapter adapter = new MyAdapter(objects);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo(){
        objects.add(new ScannedItem("eee", 4, bm));
        objects.add(new ScannedItem("eee", 4, bm));
        objects.add(new ScannedItem("eee", 4, bm));

    }



//hey brofgfd
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                Bitmap captureImage = (Bitmap) data.getExtras().get("data");
                // Here is where you inputting the values of the ML algorihtm, from extrapolatign the data
                ScannedItem o = new ScannedItem("hello", 4, captureImage);
                objects.add(o);
                System.out.println("haris");
                setAdapter();
            }



//            imageview.setImageBitmap(captureImage);
        }
    }
}