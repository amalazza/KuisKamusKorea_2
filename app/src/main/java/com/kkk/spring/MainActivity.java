package com.kkk.spring;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void kuis(View view) {
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);
        Intent i = new Intent(MainActivity.this , KuisActivity.class);
        startActivity(i);
    }
    public void kamus(View view) {
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);
        Intent i = new Intent(MainActivity.this , KamusActivity.class);
        startActivity(i);
    }
}
