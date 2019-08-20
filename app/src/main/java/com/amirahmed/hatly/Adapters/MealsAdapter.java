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

import com.amirahmed.hatly.Activites.DetailsActivity;
import com.amirahmed.hatly.Activites.NewDetailsActivity;
import com.amirahmed.hatly.Models.MealItem;
import com.amirahmed.hatly.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {

    List<MealItem> mealItems;

    Context context;

    public MealsAdapter(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;

        context = parent.getContext();

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meals, parent, false);

        return new MealsAdapter.MealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {

        Glide.with(context).load(mealItems.get(position).getMealImage()).into(holder.image);

        holder.name.setText(mealItems.get(position).getMealName());
        holder.price.setText(mealItems.get(position).getMealPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,NewDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealItems.size();
    }

    class MealsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,price;

        MealsViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
