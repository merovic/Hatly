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
import com.amirahmed.hatly.Adapters.RestaurantsListAdapter;
import com.amirahmed.hatly.Models.MealItem;
import com.amirahmed.hatly.Models.RestaurantItem;
import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.MyUtilFile;
import com.amirahmed.hatly.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class MealsActivity extends AppCompatActivity {

    Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language = 1;

    private List<MealItem> mealItems;
    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

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
            textView.setText("Food");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MealsActivity.super.onBackPressed();
                }
            });

          //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {

            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Food");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MealsActivity.super.onBackPressed();
                }
            });


          //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        rv.setLayoutManager(new GridLayoutManager(this,2));

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        mealItems = new ArrayList<>();

        if(language==1)
        {
            mealItems.add(new MealItem(R.drawable.beef,"","Meat"));
            mealItems.add(new MealItem(R.drawable.chiecken,"","Chickens"));
            mealItems.add(new MealItem(R.drawable.fishfreach,"","Fishes"));
            mealItems.add(new MealItem(R.drawable.takeaway,"","Fast Food"));
        }else
        {
            mealItems.add(new MealItem(R.drawable.beef,"","Meat"));
            mealItems.add(new MealItem(R.drawable.chiecken,"","Chickens"));
            mealItems.add(new MealItem(R.drawable.fishfreach,"","Fishes"));
            mealItems.add(new MealItem(R.drawable.takeaway,"","Fast Food"));
        }


    }

    private void initializeAdapter() {

        MealsAdapter adapter = new MealsAdapter(mealItems);
        rv.setAdapter(adapter);

    }
}
