package com.kkk.spring;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class KamusActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamus);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://zkorean.com/english-korean-dictionary");

        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowContentAccess();
    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    public void backToMain(View view) {

        Intent i = new Intent(KamusActivity.this , MainActivity.class);
        startActivity(i);
    }
}

