package com.example.go_organic.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.go_organic.DetailedActivity;
import com.example.go_organic.R;
import com.example.go_organic.models.ViewAllModel;

import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {

    Context context;
    List<ViewAllModel> list;

    public ViewAllAdapter(Context context, List<ViewAllModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice()+" / 1KG");
        holder.rating.setText(list.get(position).getRating());

        if (list.get(position).getType().equals("Diary & Eggs")){
            holder.price.setText(list.get(position).getPrice()+"/dozen");
        }

        if (list.get(position).getType().equals("Fruits")){
            holder.price.setText(list.get(position).getPrice()+"/500g");
        }

        if (list.get(position).getType().equals("salad")){
            holder.price.setText(list.get(position).getPrice()+"/100g");
        }

        if (list.get(position).getType().equals("Green & Herbs")){
            holder.price.setText(list.get(position).getPrice()+"/100g");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detail",list.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.view_all_img);
            name = itemView.findViewById(R.id.view_all_name);
            price = itemView.findViewById(R.id.view_all_price);
            rating = itemView.findViewById(R.id.view_all_rating);
        }
    }
}