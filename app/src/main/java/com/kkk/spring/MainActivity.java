package com.kkk.spring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void kuis(View view) {

        Intent i = new Intent(MainActivity.this , KuisActivity.class);
        startActivity(i);
    }
    public void kamus(View view) {

        Intent i = new Intent(MainActivity.this , KamusActivity.class);
        startActivity(i);
    }
}
