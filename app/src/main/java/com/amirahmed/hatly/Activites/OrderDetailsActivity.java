package com.amirahmed.hatly.Activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.Adapters.PersonsAdapter;
import com.amirahmed.hatly.Models.PersonItem;
import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {

    Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language = 1;

    private List<PersonItem> personItems;
    private RecyclerView rv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);

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
            textView.setText("Order Details");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderDetailsActivity.super.onBackPressed();
                }
            });


            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {

            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("My Orders");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderDetailsActivity.super.onBackPressed();
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
        personItems = new ArrayList<>();

        if(language==1)
        {
            personItems.add(new PersonItem(R.drawable.man,"Ahmed Mohamed Ibrahim","15 LE","Delivery in: 23 Min"));
            personItems.add(new PersonItem(R.drawable.man2,"Ahmed Saad Tawfek","18 LE","Delivery in: 1 Hour"));
            personItems.add(new PersonItem(R.drawable.man3,"Ibrahim Saeed Mohamed","13 LE","Delivery in: 15 Min"));
            personItems.add(new PersonItem(R.drawable.man4,"Reda Idrees Ahmed","10 LE","Delivery in: 30 Min"));
        }else
        {
            personItems.add(new PersonItem(R.drawable.man,"Ahmed Mohamed Ibrahim","15 LE","Delivery in: 23 Min"));
            personItems.add(new PersonItem(R.drawable.man2,"Ahmed Saad Tawfek","18 LE","Delivery in: 1 Hour"));
            personItems.add(new PersonItem(R.drawable.man3,"Ibrahim Saeed Mohamed","13 LE","Delivery in: 15 Min"));
            personItems.add(new PersonItem(R.drawable.man4,"Reda Idrees Ahmed","10 LE","Delivery in: 30 Min"));
        }


    }

    private void initializeAdapter() {

        PersonsAdapter adapter = new PersonsAdapter(personItems);
        rv.setAdapter(adapter);

    }
}
