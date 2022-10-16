package com.example.carboncam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    ArrayList<Post> posts ;

    public FeedAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public FeedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.MyViewHolder holder, int position) {

        Post post = posts.get(position);
        holder.carbon.setText("Carbon Rating: " + Integer.toString(post.getcarbon()));
        holder.author.setText(post.getAuthor());
        holder.description.setText(post.getDescription());
        holder.postpic.setImageBitmap(post.getPostpic());




    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView author, description, carbon;
        ImageView postpic;
        Button like, comment;

        public MyViewHolder(@NonNull View view) {
            super(view);
            author = view.findViewById(R.id.author);
            description = view.findViewById(R.id.description);
            carbon = view.findViewById(R.id.carbon);
            postpic = view.findViewById(R.id.postpic);
            like = view.findViewById(R.id.like);
            comment = view.findViewById(R.id.comment);


        }

    }
}
