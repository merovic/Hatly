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

import com.amirahmed.hatly.Activites.MealsActivity;
import com.amirahmed.hatly.Activites.OrderDetailsActivity;
import com.amirahmed.hatly.Models.OrderItem;
import com.amirahmed.hatly.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>{

    List<OrderItem> orderItems;
    Context context;

    public OrdersAdapter(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;

        context = parent.getContext();

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders, parent, false);

        return new OrdersAdapter.OrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrdersViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Glide.with(context).load(orderItems.get(position).getOrderPic()).into(holder.image);

        holder.title.setText(orderItems.get(position).getOrderName());
        holder.price.setText(orderItems.get(position).getOrderPrice());
        holder.status.setText(orderItems.get(position).getOrderStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0)
                {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(context,OrderDetailsActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    class OrdersViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,price,status;

        OrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            status = itemView.findViewById(R.id.status);
        }
    }
}
