package com.idoc.simon.idoc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiseaseCheck extends AppCompatActivity {
    //variables
    RelativeLayout relativeLayout;
    LinearLayout mainLinear,sublinear1,sublinear2,sublinear3,checkLinear;
    TextView textView;
    ScrollView scrollView;
    Button bt;
    CheckBox cb;
    String [] arr = new String[1000];
    CheckBox [] cbs = new CheckBox[1000];
    //ArrayList<String> selectedCheckboxes = new ArrayList<String>();
  //  ArrayList al=new Arraylist();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_check);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // inializing variables
        relativeLayout = (RelativeLayout) findViewById(R.id.DiseaseCheckRelative);
        mainLinear = (LinearLayout) findViewById(R.id.checkboxMainLinearlayout);
        sublinear1 = (LinearLayout) findViewById(R.id.checkboxSubLinearlayout1);
        sublinear2 = (LinearLayout) findViewById(R.id.checkboxSubLinearlayout2);
        sublinear3 = (LinearLayout) findViewById(R.id.checkboxSubLinearlayout3);
        checkLinear = (LinearLayout)findViewById(R.id.checkboxLinearLayout);
        bt = (Button) findViewById(R.id.EnterFinal);
        scrollView = (ScrollView) findViewById(R.id.scrollViewCheckbox);

        //---------------------

        for(int i = 0; i < 20; i++) {
            cbs[i] = new CheckBox(DiseaseCheck.this);
            cbs[i].setText("I'm dynamic!" + i);
            // arr[i] = "I'm dynamic"+i;
            int id = Resources.getSystem().getIdentifier("btn_check_holo_light", "drawable", "android");
            cbs[i].setButtonDrawable(id);
            checkLinear.addView(cbs[i]);

        }

        //---------------




        //----------------------

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseCheck.this , PossibleDiseaseActivity.class);
                startActivity(intent);
            }
        });




    }

}
