package com.durga.bumba.hanumanchalisa;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);


        WebView webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("file:///android_asset/hi.html");
       //webView.getSettings().setJavaScriptEnabled(true);





    }
}