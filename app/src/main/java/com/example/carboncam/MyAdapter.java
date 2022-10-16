package com.example.carboncam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<ScannedItem> objects ;

    public MyAdapter(ArrayList<ScannedItem> objects){
        this.objects = objects;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tryout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        int temp = objects.size() - position;
        ScannedItem object = objects.get(temp - 1);
        holder.score.setText(Integer.toString(object.getScore()));
        System.out.println("Hello" + object.getTitle());
        holder.title.setText(object.getTitle());
        holder.preview.setImageBitmap(object.getImageView());

        if (temp == 0) {
            holder.preview.setBackgroundResource(R.drawable.wrapper);

        }else if (temp == 1) {
            holder.preview.setBackgroundResource(R.drawable.waterbottle);

        }else if (temp == 2) {
            holder.preview.setBackgroundResource(R.drawable.coke);

        }else if (temp == 3) {
            holder.preview.setBackgroundResource(R.drawable.paperstraw);

        }



    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView score, title;
        ImageView preview;

        public MyViewHolder(@NonNull View view) {
            super(view);
            score = view.findViewById(R.id.score);
            title = view.findViewById(R.id.title);
            preview = view.findViewById(R.id.preview);


        }

    }
}
