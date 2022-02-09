package com.example.cccobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    String SpinnerValue;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GOTO = (Button)findViewById(R.id.button2);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));

           mySpinner.setAdapter(myAdapter);

                mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    SpinnerValue = (String)mySpinner.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub

                }
                });

        GOTO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                switch(SpinnerValue){
                        case "Observation 1":
                        intent = new Intent(MainActivity.this, Obs.class);
                        startActivity(intent);
                        break;
                        case "Observation 2":
                        intent = new Intent(MainActivity.this, Obs2.class);
                        startActivity(intent);
                        break;
                        case "Observation 3":
                        intent = new Intent(MainActivity.this, Obs3.class);
                        startActivity(intent);
                        break;
                        case "Observation 4":
                        intent = new Intent(MainActivity.this, Obs4.class);
                        startActivity(intent);
                        break;
                        case "Observation 5":
                        intent = new Intent(MainActivity.this, Obs5.class);
                        startActivity(intent);
                        break;
                        case "Observation 6":
                        intent = new Intent(MainActivity.this, Obs6.class);
                        startActivity(intent);
                        break;
                        case "Observation 7":
                        intent = new Intent(MainActivity.this, Obs7.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}