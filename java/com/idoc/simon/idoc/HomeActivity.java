package com.idoc.simon.idoc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    // variables
    RelativeLayout rlayout_main;
    LinearLayout   llayout_main;
    Button         syntoms_enter,diease_show,exit_button,allHospitals,allPharmacies;
  //  double latitude = 23.7513861,  lngitude =  90.3864024 ;
     double lat,lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // initialization of variables
        rlayout_main = (RelativeLayout) findViewById(R.id.relative_main);
        llayout_main = (LinearLayout) findViewById(R.id.homeLiOut);
        syntoms_enter = (Button) findViewById(R.id.button_home_syntoms);
        diease_show = (Button) findViewById(R.id.button_home_searchDiease);
        allHospitals = (Button) findViewById(R.id.allHospitals);
        allPharmacies = (Button) findViewById(R.id.alpharmacy);
        exit_button =(Button) findViewById(R.id.button_home_exit);

        // intent go to EnterInfooActivity
        syntoms_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_main_to_enterinfo = new Intent(HomeActivity.this,Diseasecheckbox.class);
                startActivity(intent_main_to_enterinfo);

            }
        });

        // intent goto DieaseSearchActivity activity
        diease_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_main_to_DSA = new Intent(HomeActivity.this,DieaseSearchActivity.class);
                startActivity(intent_main_to_DSA);
            }
        });

        //all Hospitals button

        final GPSTracker1 gps = new GPSTracker1(this);


        allHospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = gps.getLatitude();
                lng = gps.getLongitude();

                if(lat==0.0&&lng==0.0){
                    String str = "pls check connection";
                    Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                }

                else {

                    String geoURI = String.format("geo:%f,%f?q=hospital", lat, lng);
                    Uri geo = Uri.parse(geoURI);
                    Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                    startActivity(geoMap);
                }
            }
        });
        //--------------End of all hospital button------------

        //--------------All pharmacies button---------------

        allPharmacies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = gps.getLatitude();
                lng = gps.getLongitude();

                if(lat==0.0&&lng==0.0){
                    String str = "pls check Network And GPS connection";
                    Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                }

                else {

                    String geoURI = String.format("geo:%f,%f?q=pharmacy", lat, lng);
                    Uri geo = Uri.parse(geoURI);
                    Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                    startActivity(geoMap);
                }
            }
        });

        //----------end of all pharmacies work-----------

       //exit button

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
}
