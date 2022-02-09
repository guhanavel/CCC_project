package com.example.cccobs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Obs3 extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    TextView editStatus;
    TextView counter;
    Button GOTO1;
    Button GOTO2;
    Button GOTO3;
    Button GOTO4;
    Button GOTO5;
    Button Enter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_obs3);

        editStatus = (TextView)findViewById(R.id.textView2);
        counter = (TextView)findViewById(R.id.textView);

        GOTO1 = (Button)findViewById(R.id.button);
        GOTO1.setOnClickListener(this);

        GOTO2 = (Button) findViewById(R.id.button3);
        GOTO2.setOnClickListener(this);
        GOTO3 = (Button) findViewById(R.id.button4);
        GOTO3.setOnClickListener(this);
        GOTO4 = (Button) findViewById(R.id.button5);
        GOTO4.setOnClickListener(this);
        Enter = (Button) findViewById(R.id.button7);
        Enter.setOnClickListener(this);


    }
    //This is the part where data is transferred from Your Android phone to Sheet by using HTTP Rest API calls

    private void   addItemToSheet() {


        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String name3 = editStatus.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxETXUqoaAYby563VhvJxsnObpgX0heKOLgXUYidqU70e1RjjiVPn3R2OcsgxWG9SQY/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                //here we pass params
                params.put("action","addItem");
                params.put("name3",name3);

                return params;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }

    @Override
    public void onClick(View v) {

        if(v == Enter){
            editStatus.setText("Inactive");
            intent = new Intent(Obs3.this, MainActivity.class);
            startActivity(intent);
            addItemToSheet();
        }

        if(v == GOTO1){

            editStatus.setText("Ready");
            addItemToSheet();

        }

        if (v == GOTO2){

            editStatus.setText("Busy");
            addItemToSheet();

        }

        if (v == GOTO3){

            editStatus.setText("Issue");
            addItemToSheet();

        }

        if (v == GOTO4){

            editStatus.setText("Call Again");
            addItemToSheet();

        }

    }
}