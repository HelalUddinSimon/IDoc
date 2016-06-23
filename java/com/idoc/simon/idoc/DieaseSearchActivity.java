package com.idoc.simon.idoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DieaseSearchActivity extends AppCompatActivity {


    //variables

    RelativeLayout relative_ads;
    LinearLayout llout_ads,llout1_ads,Linear_ads;
    EditText editText_ads;
    Button  enter_button_ads,back_button_ads,exit_button_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diease_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing

        Linear_ads = (LinearLayout) findViewById(R.id.relative_ads);
        llout_ads = (LinearLayout) findViewById(R.id.llayout_ads);
        relative_ads = (RelativeLayout) findViewById(R.id.Rlayout1_ads);
        editText_ads = (EditText) findViewById(R.id.editText_ads);
        enter_button_ads = (Button) findViewById(R.id.button_enter_ads);
        back_button_ads = (Button) findViewById(R.id.button_back_ads);
        exit_button_ads = (Button) findViewById(R.id.button_exit_ads);


        enter_button_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dname = editText_ads.getText().toString();

                Toast.makeText(getBaseContext(), Dname, Toast.LENGTH_LONG).show();

                Intent Dsa_to_diseaseSymptoms = new Intent(DieaseSearchActivity.this , DiseaseSymptoms2.class);
                Dsa_to_diseaseSymptoms.putExtra("Dname", Dname);
                startActivity(Dsa_to_diseaseSymptoms);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //test

   // @Override


}
