package com.kkk.spring;

public class soal {
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String answer;

    public  soal(){}

    public soal(String question, String opta, String optb, String optc, String answer) {
        this.question = question;
        this.opta = opta;
        this.optb = optb;
        this.optc = optc;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpta() {
        return opta;
    }

    public void setOpta(String opta) {
        this.opta = opta;
    }

    public String getOptb() {
        return optb;
    }

    public void setOptb(String optb) {
        this.optb = optb;
    }

    public String getOptc() {
        return optc;
    }

    public void setOptc(String optc) {
        this.optc = optc;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
