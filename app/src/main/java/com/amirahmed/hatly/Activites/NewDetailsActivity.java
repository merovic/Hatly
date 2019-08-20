package com.amirahmed.hatly.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;
import com.schibstedspain.leku.LocationPickerActivity;

import static com.schibstedspain.leku.LocationPickerActivityKt.LATITUDE;
import static com.schibstedspain.leku.LocationPickerActivityKt.LOCATION_ADDRESS;
import static com.schibstedspain.leku.LocationPickerActivityKt.LONGITUDE;
import static com.schibstedspain.leku.LocationPickerActivityKt.TRANSITION_BUNDLE;
import static com.schibstedspain.leku.LocationPickerActivityKt.ZIPCODE;

public class NewDetailsActivity extends AppCompatActivity {

    Button inc,dec;
    TextView value;

    EditText location;

    int number = 0;

    Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language = 1;

    int MAP_BUTTON_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdetails);

        tinyDB = new TinyDB(getApplicationContext());

        //language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        location = findViewById(R.id.location);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent locationPickerIntent = new LocationPickerActivity.Builder()
                        .withLocation(41.4036299, 2.1743558)
                        .withSearchZone("es_ES")
                        .shouldReturnOkOnBackPressed()
                        .withStreetHidden()
                        .withCityHidden()
                        .withZipCodeHidden()
                        .withSatelliteViewHidden()
                        .build(NewDetailsActivity.this);

                startActivityForResult(locationPickerIntent, MAP_BUTTON_REQUEST_CODE);
            }
        });

        if(language==1)
        {
            mToolbar.setVisibility(View.GONE);
            mToolbar2.setVisibility(View.VISIBLE);


            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Details");


            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewDetailsActivity.super.onBackPressed();
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
                    NewDetailsActivity.super.onBackPressed();
                }
            });


            //  new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }

        value = findViewById(R.id.value);
        inc = findViewById(R.id.increment);
        dec = findViewById(R.id.decrement);

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = number + 1;

                value.setText(String.valueOf(number));
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number!=0)
                {
                    number = number - 1;

                    value.setText(String.valueOf(number));
                    
                }

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            Log.d("RESULT****", "OK");
            if (requestCode == 1) {
                Double latitude = data.getDoubleExtra(LATITUDE, 0.0);
                // Log.d("LATITUDE****", latitude.toString());
                Double longitude = data.getDoubleExtra(LONGITUDE, 0.0);
                // Log.d("LONGITUDE****", longitude.toString());
                String address = data.getStringExtra(LOCATION_ADDRESS);
                //Log.d("ADDRESS****", address);
                String postalcode = data.getStringExtra(ZIPCODE);
                // Log.d("POSTALCODE****", postalcode);
                Bundle bundle = data.getBundleExtra(TRANSITION_BUNDLE);
                //Log.d("BUNDLE TEXT****", bundle.getString("test"));

                location.setText("Cairo/Egypt");

               /* val fullAddress = data.getParcelableExtra<Address>(ADDRESS);
                if (fullAddress != null) {
                    Log.d("FULL ADDRESS****", fullAddress.toString());
                }
                val timeZoneId = data.getStringExtra(TIME_ZONE_ID)
                Log.d("TIME ZONE ID****", timeZoneId);
                val timeZoneDisplayName = data.getStringExtra(TIME_ZONE_DISPLAY_NAME)
                Log.d("TIME ZONE NAME****", timeZoneDisplayName)
            } else if (requestCode == 2) {
                val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                Log.d("LATITUDE****", latitude.toString())
                val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                Log.d("LONGITUDE****", longitude.toString())
                val address = data.getStringExtra(LOCATION_ADDRESS)
                Log.d("ADDRESS****", address.toString())
                val lekuPoi = data.getParcelableExtra<LekuPoi>(LEKU_POI)
                        Log.d("LekuPoi****", lekuPoi.toString())*/
            }
        }
        if (resultCode == Activity.RESULT_CANCELED) {
            Log.d("RESULT****", "CANCELLED");
        }


    }
}
