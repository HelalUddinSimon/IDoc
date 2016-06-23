package com.idoc.simon.idoc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Hospitalss extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //variables -----------------

    RelativeLayout hRelativeL;
    LinearLayout hLinearL,hSubLinearL1,hSubLinearL2,hSubLinearL3;
    TextView hTV_hospitals;
    ListView hListV;
    Button hButton1;
    double latitude = 23.751658,  lngitude =  90.367308  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalss);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing variables

        hRelativeL = (RelativeLayout) findViewById(R.id.hRelativeLayout);
        hLinearL = (LinearLayout) findViewById(R.id.hLinearLayout);
        hSubLinearL1 = (LinearLayout) findViewById(R.id.hSubLinearLayout1);
        hSubLinearL2 = (LinearLayout) findViewById(R.id.hSubLinearLayout2);
       // hSubLinearL3 = (LinearLayout) findViewById(R.id.hSubLinearLayout3);
        hTV_hospitals = (TextView) findViewById(R.id.htextView_hospitals);
        hListV = (ListView) findViewById(R.id.hlistView1);
        //hButton1 = (Button) findViewById(R.id.hbutton_findOnMap);

        // enter on map button

        //list view

        int[] colors = {0, 0xFFFF0000, 0}; // red for the example
        hListV.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        hListV.setDividerHeight(1);

        List<String> array_list = new ArrayList<String>();
        array_list.add("LabAid");
        array_list.add("Appolo");
        array_list.add("Hospital 1");
        array_list.add("Hospital 2");
        array_list.add("Hospital 3");
        array_list.add("AHospital 4");
        array_list.add("Hospital 5");
        array_list.add("Hospital 6");
        array_list.add("Hospital 7");
        array_list.add("Hospital 8");
        array_list.add("Hospital 9");
        array_list.add("Hospital 10 ");
        //array_list.subList(0,0);


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, array_list) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.parseColor("#2196F3"));
                return view;

            }

        };
        hListV.setAdapter(adapter);

        //ItemClick actionListner for listView
        GPSTracker1 gps = new GPSTracker1(this);
        final double lat = gps.getLatitude();
        final double lng = gps.getLongitude();

        //-- for hospital  -------------------------

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> addresses  = null;
        try {
            addresses = geocoder.getFromLocation(latitude,lngitude , 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String city = addresses.get(0).getLocality();
        final String state = addresses.get(0).getAdminArea();
        final String zip = addresses.get(0).getPostalCode();
        String country = addresses.get(0).getCountryName();

        //------------for gps-------------

        Geocoder geocoder1 = new Geocoder(this, Locale.getDefault());

        List<Address> addresses1  = null;
        try {
            addresses1 = geocoder1.getFromLocation(lat,lng , 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String city1 = addresses1.get(0).getLocality();
        final String state1 = addresses1.get(0).getAdminArea();
        final String zip1 = addresses1.get(0).getPostalCode();
        String country1 = addresses1.get(0).getCountryName();

        hListV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();

                final Intent intent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?" +
                        "saddr=" + lat + "," + lng +city1+state1+zip1+ "&daddr=" + latitude + "," +
                        lngitude + city+state+zip));
                intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hospitalss, menu);
        return true;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Intent intent = new Intent( Hospitalss.this, HomeActivity.class );
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);

        } else if (id == R.id.nav_pdisease) {
            Intent in2 = new Intent(Hospitalss.this,PossibleDiseaseActivity.class);
            in2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(in2);
        }   else if (id == R.id.nav_DiseaseCheck) {
            Intent in3 = new Intent(Hospitalss.this,Diseasecheckbox.class);
            in3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in3);
        }
        else if (id == R.id.nav_DiseaseRadion) {
            Intent in3 = new Intent(Hospitalss.this,DiseaseCheck.class);
            in3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in3);
        }
        else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
