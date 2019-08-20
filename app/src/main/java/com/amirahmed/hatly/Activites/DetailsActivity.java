package com.amirahmed.hatly.Activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;

public class DetailsActivity extends AppCompatActivity {

    Button inc,dec;
    TextView value,total;

    int number = 0;

    Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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
            textView.setText("Details");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailsActivity.super.onBackPressed();
                }
            });

            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
        {

            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Details");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailsActivity.super.onBackPressed();
                }
            });


            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        value = findViewById(R.id.value);
        inc = findViewById(R.id.increment);
        dec = findViewById(R.id.decrement);

        total = findViewById(R.id.total);

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = number + 1;

                value.setText(String.valueOf(number));

                total.setText(String.valueOf(120*number + " LE"));
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number!=0)
                {
                    number = number - 1;

                    value.setText(String.valueOf(number));

                    total.setText(String.valueOf(120*number + " LE"));
                }

            }
        });

    }
}
