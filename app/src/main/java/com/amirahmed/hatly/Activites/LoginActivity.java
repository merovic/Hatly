package com.amirahmed.hatly.Activites;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;


public class LoginActivity extends AppCompatActivity {

    Button login;

    EditText email,password;

    TextView skip,newaccount;

    TinyDB tinyDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tinyDB = new TinyDB(this);

        login = findViewById(R.id.loginbutton);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);

        skip = findViewById(R.id.skiplogin);
        newaccount = findViewById(R.id.newaccount);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });




        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }



}
