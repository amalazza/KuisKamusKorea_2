package com.kkk.spring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KuisAlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_alphabet);
    }

    public void backToMain2(View view) {

        Intent i = new Intent(KuisAlphabetActivity.this , KuisActivity.class);
        startActivity(i);
    }
}