package com.uk.sampledata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class Pdfshare extends AppCompatActivity {

   // WebView webView;
    String pdfLink="";
    Button share,select;


    private static Uri imageUri = null;

    private final int select_photo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfshare);
/*
webView=findViewById(R.id.webview1);
        *//*Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + pdfLink), "text/html");

        startActivity(intent);*//*

        webView.getSettings().setJavaScriptEnabled(true);
       // webView.getSettings().setPluginsEnabled(true);
       // webView.loadUrl("docs.google.com/viewer?url="+pdfLink);
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdfLink);*/


        share=findViewById(R.id.share);
        select=findViewById(R.id.select);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_PICK);
                in.setType("image/*");
                startActivityForResult(in, select_photo);
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.setType("image/*");
               // sharingIntent.putExtra(Intent.EXTRA_STREAM, imagePath);
                startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
            }
        });
    }


    protected void onActivityResult(int requestcode, int resultcode,
                                    Intent imagereturnintent) {
        super.onActivityResult(requestcode, resultcode, imagereturnintent);
        switch (requestcode) {
            case select_photo:
                if (resultcode == RESULT_OK) {
                    try {

                        imageUri = imagereturnintent.getData();// Get intent
                        // data

                        Bitmap bitmap = Utils.decodeUri(Pdfshare.this,
                                imageUri, 200);// call
                        // deocde
                        // uri
                        // method
                        // Check if bitmap is not null then set image else show
                        // toast
                        if (bitmap != null) {
                            // imageView.setImageBitmap(bitmap);// Set image over
                            // bitmap
                            // shareImage.setVisibility(View.VISIBLE);// Visible button
                            // if bitmap is
                            // not null
                        } else {
                            //  shareImage.setVisibility(View.GONE);
                            Toast.makeText(Pdfshare.this,
                                    "Error while decoding image.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                        Toast.makeText(Pdfshare.this, "File not found.",
                                Toast.LENGTH_SHORT).show();
                    }

                }
        }
    }

}