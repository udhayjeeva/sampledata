package com.uk.sampledata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.github.ybq.android.spinkit.SpinKitView;

public class MainActivity extends AppCompatActivity {


    Button button1;
    SpinKitView spinKitView;
    private static int TIME_OUT = 4000;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            context=this;
        button1=findViewById(R.id.button1);

        spinKitView=findViewById(R.id.spin_kit);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinKitView.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent tointent=new Intent(MainActivity.this,MainActivity2.class);
                        spinKitView.setVisibility(View.GONE);
                        startActivity(tointent);
                    }
                }, TIME_OUT);


                
            }
        });
    }
}