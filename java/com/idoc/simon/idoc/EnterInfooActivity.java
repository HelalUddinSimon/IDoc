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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterInfooActivity extends AppCompatActivity {

    RelativeLayout rlayout_enter;
    LinearLayout llayout_enter,llayout_enter_1;
    Button ok_button,enter_button,back_button,exit_button;
    ListView lvEnter1;
    EditText EtEnter1;
    //adapter for list show
    ArrayAdapter<String> m_adapter;
    ArrayList<String> m_listItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_infoo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rlayout_enter = (RelativeLayout) findViewById(R.id.rlayEnter);
        llayout_enter = (LinearLayout) findViewById(R.id.llay_Enter);
        //llayout_enter_1 = (LinearLayout) findViewById(R.id.llay_enter1);
        ok_button = (Button) findViewById(R.id.button_ok);
        back_button = (Button) findViewById(R.id.button_back);
        exit_button = (Button) findViewById(R.id.button_exit);
        lvEnter1 = (ListView) findViewById(R.id.listView_ESV);
        EtEnter1 = (EditText) findViewById(R.id.editText_synName);
        enter_button = (Button) findViewById(R.id.button_enter);



        int[] colors = {0, 0xFFFF0000, 0}; // red for the example
        lvEnter1.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        lvEnter1.setDividerHeight(1);

        m_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m_listItems);

        //OK button work
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvEnter1.setAdapter(m_adapter);
                String input = EtEnter1.getText().toString();
                //input.setTextColor(Color.parseColor("#2196F3"));

                String[] values = new String[] {"", input};

                if(null!=input&&input.length()>0){

                    m_listItems.add(input);

                    m_adapter.notifyDataSetChanged();


                }
                EtEnter1.setText("");
            }
        });

        //test


        //

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_DiseaseSymtoms = new Intent(EnterInfooActivity.this , PossibleDiseaseActivity.class);
                startActivity(intent_to_DiseaseSymtoms);
            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);//not exiting fully,just backing to the privious page
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
