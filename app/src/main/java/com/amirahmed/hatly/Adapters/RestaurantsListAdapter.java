package com.amirahmed.hatly.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.Activites.MealsActivity;
import com.amirahmed.hatly.Models.RestaurantItem;
import com.amirahmed.hatly.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RestaurantsListAdapter extends RecyclerView.Adapter<RestaurantsListAdapter.RestaurantsListViewHolder> {

    List<RestaurantItem> restaurantItems;

    Context context;

    public RestaurantsListAdapter(List<RestaurantItem> restaurantItems) {
        this.restaurantItems = restaurantItems;
    }

    @NonNull
    @Override
    public RestaurantsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;

        context = parent.getContext();

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurants, parent, false);

        return new RestaurantsListAdapter.RestaurantsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsListViewHolder holder, int position) {

        Glide.with(context).load(restaurantItems.get(position).getRestaurantPicture()).into(holder.picture);

        holder.name.setText(restaurantItems.get(position).getRestaurantName());
        holder.slogan.setText(restaurantItems.get(position).getRestaurantSlogan());

        if(position==0)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context,MealsActivity.class);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return restaurantItems.size();
    }

    class RestaurantsListViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name,slogan;

        RestaurantsListViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.picture);
            name = itemView.findViewById(R.id.name);
            slogan = itemView.findViewById(R.id.slogan);
        }
    }
}
