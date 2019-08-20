package com.amirahmed.hatly.Activites;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.hatly.Adapters.RestaurantsListAdapter;
import com.amirahmed.hatly.Models.RestaurantItem;
import com.amirahmed.hatly.Utils.MyUtilFile;
import com.amirahmed.hatly.Utils.NavigationDrawerCallbacks;
import com.amirahmed.hatly.Fragments.NavigationDrawerFragment;
import com.amirahmed.hatly.R;
import com.amirahmed.hatly.Utils.TinyDB;
import com.schibstedspain.leku.LocationPickerActivity;

import java.util.ArrayList;
import java.util.List;

import static com.schibstedspain.leku.LocationPickerActivityKt.LATITUDE;
import static com.schibstedspain.leku.LocationPickerActivityKt.LOCATION_ADDRESS;
import static com.schibstedspain.leku.LocationPickerActivityKt.LONGITUDE;
import static com.schibstedspain.leku.LocationPickerActivityKt.TRANSITION_BUNDLE;
import static com.schibstedspain.leku.LocationPickerActivityKt.ZIPCODE;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    Toolbar mToolbar,mToolbar2;

    Button button;

    int MAP_BUTTON_REQUEST_CODE = 1;

    private List<RestaurantItem> restaurantItems;
    private RecyclerView rv;

    TinyDB tinyDB;

    int language = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinyDB = new TinyDB(getApplicationContext());

        //language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);


            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("Home");


           // new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
        }else
            {
                mToolbar2.setVisibility(View.VISIBLE);
                mToolbar.setVisibility(View.GONE);


                TextView textView = mToolbar2.findViewById(R.id.toolbartext);
                textView.setText("Home");


               // new MyUtilFile(language,mToolbar,mToolbar2).getActionBarTextView().setVisibility(View.GONE);
            }

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("Username", "username@gmail.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        mNavigationDrawerFragment.closeDrawer();

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
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
                        .build(MainActivity.this);

                startActivityForResult(locationPickerIntent, MAP_BUTTON_REQUEST_CODE);

            }
        });
    }


    private void initializeData() {
        restaurantItems = new ArrayList<>();

        if(language==1)
        {
            restaurantItems.add(new RestaurantItem("Food","Ask for any Food",R.drawable.food));
            restaurantItems.add(new RestaurantItem("Electric Appliances","Bring your home appliances",R.drawable.homeappliances));
            restaurantItems.add(new RestaurantItem("Super Market","Your Home Requirements",R.drawable.supermarket));
            restaurantItems.add(new RestaurantItem("Pharmacy","Request anything from Pharmacy",R.drawable.pharmacy));
            restaurantItems.add(new RestaurantItem("Furniture","Complete your home",R.drawable.furn));
            restaurantItems.add(new RestaurantItem("Cleaning","For your cleaning purposes",R.drawable.cleaning));
        }else
        {
            restaurantItems.add(new RestaurantItem("Food","Ask for any Food",R.drawable.food));
            restaurantItems.add(new RestaurantItem("Electric Appliances","Bring your home appliances",R.drawable.homeappliances));
            restaurantItems.add(new RestaurantItem("Super Market","Your Home Requirements",R.drawable.supermarket));
            restaurantItems.add(new RestaurantItem("Pharmacy","Request anything from Pharmacy",R.drawable.pharmacy));
            restaurantItems.add(new RestaurantItem("Furniture","Complete your home",R.drawable.furn));
            restaurantItems.add(new RestaurantItem("Cleaning","For your cleaning purposes",R.drawable.cleaning));
        }


    }

    private void initializeAdapter() {

        RestaurantsListAdapter adapter = new RestaurantsListAdapter(restaurantItems);
        rv.setAdapter(adapter);

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




    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
       // Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();

        Intent intent;

        switch (position) {
            case 0:

                intent = new Intent(this, MyOrdersActivity.class);
                startActivity(intent);

                break;

            case 1:
               // intent = new Intent(this, MyProfileActivity.class);
               // startActivity(intent);

                break;

            case 2:

               // intent = new Intent(this, MyProfileActivity.class);
               // startActivity(intent);

                break;

            case 3:

                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);

                break;

        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            {
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
            }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
