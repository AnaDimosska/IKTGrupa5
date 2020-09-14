package com.example.iktgrupa5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Item> list;

    public Adapter(Context context, ArrayList<Item> list){
        this.context=context;
        this.list=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Item currentItem=list.get(position);
      String imageUrl=currentItem.getImageUrl();
      String creatorName=currentItem.getCreator();
      int likes=currentItem.getLikes();
      holder.textView.setText(creatorName);
      holder.textView2.setText("Likes"+likes);
      Glide.with(context).load(imageUrl).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
            textView=itemView.findViewById(R.id.textview_creator);
            textView2=itemView.findViewById(R.id.textview_like);
        }
    }
}
