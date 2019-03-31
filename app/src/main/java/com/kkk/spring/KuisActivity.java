package com.kkk.spring;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kkk.spring.data.DbHelper;

import java.util.List;
import java.util.Locale;

public class KuisActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;
    private static final int REQUEST_CODE_QUIZ2 = 1;
    private static final int REQUEST_CODE_QUIZ3 = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView txthighscore;
    private int highscore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        txthighscore = findViewById(R.id.highscore);
        loadHighscore();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(KuisAlphabetActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        } else if (requestCode == REQUEST_CODE_QUIZ2) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(KuisAlphabetActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        } else if (requestCode == REQUEST_CODE_QUIZ3) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(KuisAlphabetActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        txthighscore.setText("" +highscore);
    }

    private void updateHighscore(int highscoreNew){
        highscore = highscoreNew;
        txthighscore.setText("" +highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }


    public void kuisAlpha(View view) {

        final Vibrator vibe = (Vibrator) KuisActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);
        Intent i = new Intent(KuisActivity.this , KuisAlphabetActivity.class);
        startActivityForResult(i, REQUEST_CODE_QUIZ);
    }

    public void kuisKata(View view) {
        final Vibrator vibe = (Vibrator) KuisActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);
        Intent i = new Intent(KuisActivity.this , KuisKataActivity.class);
        startActivityForResult(i, REQUEST_CODE_QUIZ2);
    }

    public void kuisKalimat(View view) {
        final Vibrator vibe = (Vibrator) KuisActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);
        Intent i = new Intent(KuisActivity.this , KuisKalimatActivity.class);
        startActivityForResult(i, REQUEST_CODE_QUIZ3);
    }
}
