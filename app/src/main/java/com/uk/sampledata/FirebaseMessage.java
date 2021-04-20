package com.uk.sampledata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class FirebaseMessage extends AppCompatActivity {

    TextView submt;
    Context context;
   // WebView webView;
    String path="";
    LinearLayout llinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_message);
        context=this;
        llinner=findViewById(R.id.llinner);
        submt=findViewById(R.id.submit);
           // webView=findViewById(R.id.webview);
        Uri uri=getIntent().getData();
        if(uri!=null)
        {
            path=uri.toString();
            Toast.makeText(context,"Path===>"+path,Toast.LENGTH_SHORT).show();
        }

              /*  try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.app.ilimtutor"));
                    startActivity(intent);
                } catch (Exception e) { //google play app is not installed
                   *//* Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.app.ilimtutor"));
                    startActivity(intent);*//*

                    System.out.println("---"+e);
                }*/

        Drawable unwrappedDrawable = llinner.getBackground();
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, (Color.parseColor("#C99753")));

        // llinner.setBackgroundResource(R.color.purple_200);
       // llinner.setBackgroundColor(Color.parseColor("#C99753"));
       // webView.loadUrl(path);
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.e("newToken---", refreshedToken);
        submt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.showAlertDialog(context,"HAI","Welcome to New ");

            }
        });




    }
}