package com.kkk.spring.data;

import android.provider.BaseColumns;

import com.kkk.spring.KuisAlphabetActivity;

public final class QuizContract {
    private QuizContract(){

    }
    public static class KuisEntry implements BaseColumns{
        public static final String TABLE_QUEST = "quest";
        public static final String KEY_QUES = "question";
        public static final String KEY_OPTA = "opta";
        public static final String KEY_OPTB = "optb";
        public static final String KEY_OPTC = "optc";
        public static final String KEY_ANSWER = "answer";
    }
}
