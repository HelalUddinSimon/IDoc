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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PossibleDiseaseActivity extends AppCompatActivity {

    RelativeLayout pbRl;
    LinearLayout mainLL,subLL1,subLL2;
    ListView listView1,listView2;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possible_disease);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing all varibles

        pbRl = (RelativeLayout) findViewById(R.id.pbRelative_layout);
        mainLL = (LinearLayout) findViewById(R.id.pbLinearLayout);
        subLL1 = (LinearLayout) findViewById(R.id.pbSubLinearlayout);
        subLL2 = (LinearLayout) findViewById(R.id.pbSubLinearlayout2);
        listView1 = (ListView) findViewById(R.id.pbDiseaseListView);
        listView2 = (ListView) findViewById(R.id.pbDiseasePercentListView);
        view = (View) findViewById(R.id.generalView);



        //view1

        int[] colors = {0, 0xFFFF0000, 0}; // red for the example
        listView1.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView1.setDividerHeight(1);


        List<String> array_list = new ArrayList<String>();
        array_list.add("Hepatitis E");
        array_list.add("Typhoid fever");
        array_list.add("Dengue fever");
        array_list.add("Yellow fever");
        array_list.add("Japanese Encephalitis");
        array_list.add("African Trypanosomiasis");
        array_list.add("Cutaneous Leishmaniasis");
        array_list.add("Plague");
        array_list.add("Rift Valley fever");
        array_list.add("Chikungunya");
        array_list.add("Leptospirosis");
        array_list.add("Schistosomiasis ");

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
       listView1.setAdapter(adapter);

        //

        //view2

        int[] colors2 = {0, 0xFFFF0000, 0}; // red for the example
        listView2.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors2));
        listView2.setDividerHeight(1);

        List<String> array_list2 = new ArrayList<String>();
        array_list2.add("90%");
        array_list2.add("85%");
        array_list2.add("80%");
        array_list2.add("75%");
        array_list2.add("70%");
        array_list2.add("65%");
        array_list2.add("60%");
        array_list2.add("55%");
        array_list2.add("54%");
        array_list2.add("51%");
        array_list2.add("50%");
        array_list2.add("45%");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, array_list2) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.parseColor("#2196F3"));
                return view;

            }

        };
        listView2.setAdapter(adapter2);

        //

        //ItemClick actionListner for listView

      /*  listView2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),DiseaseSymptoms.class);
                // intent.putExtra("list_view_value", str);
                startActivity(intent);
            }
        });*/


        //item click for list1

       listView1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),disease_symptoms.class);
                 intent.putExtra("Disease_name", str);
                 startActivity(intent);
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
