package com.amirahmed.hatly.Activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.Adapters.MealsAdapter;
import com.amirahmed.hatly.Adapters.OrdersAdapter;
import com.amirahmed.hatly.Models.MealItem;
import com.amirahmed.hatly.Models.OrderItem;
import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {

    Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language = 1;

    private List<OrderItem> orderItems;
    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);
        tinyDB = new TinyDB(getApplicationContext());

        //language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        if(language==1)
        {
            mToolbar.setVisibility(View.GONE);
            mToolbar2.setVisibility(View.VISIBLE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("My Orders");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyOrdersActivity.super.onBackPressed();
                }
            });


            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {

            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Home");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyOrdersActivity.super.onBackPressed();
                }
            });


            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        orderItems = new ArrayList<>();

        if(language==1)
        {
            orderItems.add(new OrderItem(R.drawable.beef,"2 KG Raw Beaf","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.homeappliances,"Samsung LED TV 32INCH","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.supermarket,"1 Bottle shampoo for men","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.pharmacy,"1 Antibiotic 100gm","150 LE","Order Pending"));
        }else
        {
            orderItems.add(new OrderItem(R.drawable.food,"Pizza Oriental - With Sausages","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.food,"Pizza Oriental - With Sausages","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.food,"Pizza Oriental - With Sausages","150 LE","Order Pending"));
            orderItems.add(new OrderItem(R.drawable.food,"Pizza Oriental - With Sausages","150 LE","Order Pending"));
        }


    }

    private void initializeAdapter() {

        OrdersAdapter adapter = new OrdersAdapter(orderItems);
        rv.setAdapter(adapter);

    }
}
