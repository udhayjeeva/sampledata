package com.uk.sampledata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity2 extends AppCompatActivity {

    WebView webView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView=findViewById(R.id.webview);
        url = "https://alliedmotors.com/privacy/";

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
        Document document = Jsoup.connect(url).get();
        document.getElementsByClass("header-container").remove();
        document.getElementsByClass("footer").remove();
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
//mWebView.loadData(document.toString(),"text/html","utf-8");
        webView.loadDataWithBaseURL(url,document.toString(),"text/html","utf-8","");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}