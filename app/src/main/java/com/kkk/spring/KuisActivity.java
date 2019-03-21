package com.kkk.spring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class KuisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

    }

    public void backToMain(View view) {

        Intent i = new Intent(KuisActivity.this , MainActivity.class);
        startActivity(i);
    }

    public void kuisAlpha(View view) {

        Intent i = new Intent(KuisActivity.this , KuisAlphabetActivity.class);
        startActivity(i);
    }

    public void kuisKata(View view) {

        Intent i = new Intent(KuisActivity.this , KuisKataActivity.class);
        startActivity(i);
    }

    public void kuisKalimat(View view) {

        Intent i = new Intent(KuisActivity.this , KuisKalimatActivity.class);
        startActivity(i);
    }
}
