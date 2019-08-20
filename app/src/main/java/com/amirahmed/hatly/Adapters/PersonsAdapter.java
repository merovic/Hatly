package com.amirahmed.hatly.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.Activites.OfferActivity;
import com.amirahmed.hatly.Models.PersonItem;
import com.amirahmed.hatly.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonsViewHolder> {

    List<PersonItem> personItems;

    Context context;

    public PersonsAdapter(List<PersonItem> personItems) {
        this.personItems = personItems;
    }

    @NonNull
    @Override
    public PersonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;

        context = parent.getContext();

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persons, parent, false);

        return new PersonsAdapter.PersonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Glide.with(context).load(personItems.get(position).getPersonImage()).into(holder.image);

        holder.title.setText(personItems.get(position).getPersonName());
        holder.price.setText(personItems.get(position).getPersonDistance());
        holder.distance.setText(personItems.get(position).getPersonOffer());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0)
                {
                    Intent intent = new Intent(context,OfferActivity.class);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return personItems.size();
    }

    class PersonsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,price,distance;

        PersonsViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            distance = itemView.findViewById(R.id.distance);
        }
    }
}
