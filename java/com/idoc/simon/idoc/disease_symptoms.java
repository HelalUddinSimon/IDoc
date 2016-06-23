package com.idoc.simon.idoc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class disease_symptoms extends AppCompatActivity {
    RelativeLayout dsRelativeL;
    LinearLayout dsLinearL,dsLinearL1,dsLinearL2,dsLinearL3;
    TextView dsTVlarge,dsTVmedium;
    ListView listView;
    Button dsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_symptoms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // initializing variables

        dsRelativeL = (RelativeLayout) findViewById(R.id.dsRelative_layout);
        dsLinearL = (LinearLayout) findViewById(R.id.dsLinearLayout);
        dsLinearL1 = (LinearLayout) findViewById(R.id.dsSubLinearLayout1);
        dsLinearL2 = (LinearLayout) findViewById(R.id.dsSubLinearLayout2);
        dsLinearL3 = (LinearLayout) findViewById(R.id.dsSubLinearLayout3);
        dsTVlarge = (TextView) findViewById(R.id.dstextView_diseaseName);
        dsTVmedium = (TextView) findViewById(R.id.dstextView_Symptoms);
        listView = (ListView) findViewById(R.id.dslistView1);
        dsbutton = (Button) findViewById(R.id.dsbutton_AvailableHospital);

        //text getting for large text view
        dsTVlarge.setText( getIntent().getStringExtra("Disease_name"));

        //list view
        int[] colors = {0, 0xFFFF0000, 0}; // red for the example
        listView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView.setDividerHeight(1);


        List<String> array_list = new ArrayList<String>();
        array_list.add("Symptomps 1");
        array_list.add("Symptomps 2");
        array_list.add("Symptomps 3");
        array_list.add("Symptomps 4");
        array_list.add("Symptomps 5");
        array_list.add("Symptomps 4");
        array_list.add("Symptomps 5");
        array_list.add("Symptomps 6");
        array_list.add("Symptomps 7");
        array_list.add("Symptomps 8");
        array_list.add("Symptomps 9");
        array_list.add("Symptomps 10 ");

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
        listView.setAdapter(adapter);

        dsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_Hospitals = new Intent(disease_symptoms.this , Hospitalss.class);
                startActivity(intent_to_Hospitals);
            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
