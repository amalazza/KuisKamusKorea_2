package com.kkk.spring;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kkk.spring.data.DbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class KuisAlphabetActivity extends AppCompatActivity {

    public static String EXTRA_SCORE = "extra score";
    public static final long COUNTDOWN_IN_MILLIS = 10000;

    private static final String KEY_SCORE_S = "keyScore";
    private static final String KEY_QUESTION_COUNT_S = "keyQuestionCountA";
    private static final String KEY_MILLIS_LEFT_S = "keyMillisLeftA";
    private static final String KEY_ANSWERED_S = "keyAnsweredA";
    private static final String KEY_QUESTION_LIST_S = "keyQuestionListA";

    private TextView soal;
    private TextView txtscore;
    private TextView count;
    private TextView timer;
    private TextView answers;
    private Button opta;
    private Button optb;
    private Button optc;
    private ArrayList<? extends com.kkk.spring.soal> questionList;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private int questionCounter;
    private int questionCountTotal;
    private soal currentQuestion;
    private int score;
    private boolean answer;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_kalimat);
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        soal = findViewById(R.id.soal);
        txtscore = findViewById(R.id.score);
        count = findViewById(R.id.count);
        timer = findViewById(R.id.timer);
        opta = findViewById(R.id.opta);
        optb = findViewById(R.id.optb);
        optc = findViewById(R.id.optc);
        answers = findViewById(R.id.answer);

        textColorDefaultRb = opta.getTextColors();
        textColorDefaultCd = timer.getTextColors();

        if(savedInstanceState == null) {
            DbHelper dbHelper = new DbHelper(this);
            questionList = dbHelper.getAlpQuestion();
            questionCountTotal = questionList.size();

            showNextQuestion();
        }
        else{
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST_S);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT_S);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE_S);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT_S);
            answer = savedInstanceState.getBoolean(KEY_ANSWERED_S);

            if(!answer){
                startCountDown();
            }
            else{
                updateCountdownText();
            }
        }

        opta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                opta();
            }
        });

        optb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                optb();
            }
        });

        optc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                optc();
            }
        });

    }

    private void opta(){
        if(opta.getText().equals(answers.getText())){
            opta.setTextColor(Color.GREEN);
            score++;
            txtscore.setText("" + score);
            if(questionCounter < questionCountTotal){
                AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                msgBox.setMessage("Right Answer!");
                msgBox.setCancelable(false);
                msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showNextQuestion();
                    }
                });
                msgBox.create().show();
            }
            else{
                done();
            }
        }
        else{
            if(optb.getText().equals(answers.getText())){

                optb.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
            else if(optc.getText().equals(answers.getText())) {
                optc.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
        }
    }



    private void optb(){

        if(optb.getText().equals(answers.getText())){
            optb.setTextColor(Color.GREEN);
            score++;
            txtscore.setText("" + score);
            if(questionCounter < questionCountTotal) {
                AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                msgBox.setMessage("Right Answer!");
                msgBox.setCancelable(false);
                msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showNextQuestion();
                    }
                });
                msgBox.create().show();
            }
            else{
                done();;
            }
        }
        else{
            if(opta.getText().equals(answers.getText())){

                opta.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
            else if(optc.getText().equals(answers.getText())){
                optc.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
        }
    }

    private void optc(){
        if(optc.getText().equals(answers.getText())){
            score++;
            txtscore.setText("" + score);
            optc.setTextColor(Color.GREEN);
            if(questionCounter < questionCountTotal) {
                AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                msgBox.setMessage("Right Answer!");
                msgBox.setCancelable(false);
                msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showNextQuestion();
                    }
                });
                msgBox.create().show();
            }
            else{
                done();
            }
        }
        else{
            if(optb.getText().equals(answers.getText())){
                optb.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
            else if(opta.getText().equals(answers.getText())){
                opta.setTextColor(Color.GREEN);
                if(questionCounter < questionCountTotal) {
                    final Vibrator vibe = (Vibrator) KuisAlphabetActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
                    msgBox.setMessage("Wrong Answer!");
                    msgBox.setCancelable(false);
                    msgBox.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                        }
                    });
                    msgBox.create().show();
                }
                else{
                    done();
                }
            }
        }
    }

    private void showNextQuestion(){
        opta.setTextColor(textColorDefaultRb);
        optb.setTextColor(textColorDefaultRb);
        optc.setTextColor(textColorDefaultRb);

        if(questionCounter < questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            soal.setText(currentQuestion.getQuestion());
            answers.setText(currentQuestion.getAnswer());
            opta.setText(currentQuestion.getOpta());
            optb.setText(currentQuestion.getOptb());
            optc.setText(currentQuestion.getOptc());

            questionCounter++;
            count.setText("" + questionCounter + "/" + questionCountTotal);
            answer = false;

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }
        else{
            finishQuiz();
        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();

            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountdownText();
                showNextQuestion();

            }
        }.start();
    }

    private void updateCountdownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timer.setText(timeFormat);

        if(timeLeftInMillis < 5000){
            timer.setTextColor(Color.RED);
        }
        else{
            timer.setTextColor(textColorDefaultCd);
        }
    }

    private void done(){
        if(score >= (questionCountTotal)/1.25){
            SweetAlertDialog msgBox = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
            msgBox.setCancelable(false);
            msgBox.setTitle("Excellent!");
            msgBox.setContentText("Your score is "+score);
            msgBox.setCustomImage(R.drawable.bagus);

            msgBox.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    finishQuiz();
                }
            });
            msgBox.show();
        }
        else if(score > (questionCountTotal)/3 && score < (questionCountTotal)/1.25){
            SweetAlertDialog msgBox = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
            msgBox.setCancelable(false);
            msgBox.setTitle("Good!");
            msgBox.setContentText("Your score is "+score);
            msgBox.setCustomImage(R.drawable.lumayan);

            msgBox.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    finishQuiz();
                }
            });
            msgBox.show();
        }
        else{
            SweetAlertDialog msgBox = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
            msgBox.setCancelable(false);
            msgBox.setTitle("Loser!");
            msgBox.setContentText("Your score is "+score);
            msgBox.setCustomImage(R.drawable.jelek);

            msgBox.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    finishQuiz();
                }
            });
            msgBox.show();
        }

    }
    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.close();
        finish();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(KuisAlphabetActivity.this);
        msgBox.setMessage("Do you want to quit?");
        msgBox.setCancelable(false);
        msgBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishQuiz();
            }
        });
        msgBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        msgBox.create().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE_S, score);
        outState.putInt(KEY_QUESTION_COUNT_S, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT_S, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED_S, answer);
        outState.putParcelableArrayList(KEY_QUESTION_LIST_S, (ArrayList<? extends Parcelable>) questionList);

    }
}
