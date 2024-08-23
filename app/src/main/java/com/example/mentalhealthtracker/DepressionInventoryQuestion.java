package com.example.mentalhealthtracker;

public class DepressionInventoryQuestion {
    public String question;
    public int score;
    public DepressionInventoryQuestion(String question, int score){
        this.question = question;
        this.score = score;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
