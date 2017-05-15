package com.example.aldemuhamad.androidquiz;

/**
 * Created by aldemuhamad on 5/14/2017.
 */

public class ExplainModel {
    private String answer;
    private String explain;

    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getExplain(){
        return explain;
    }
    public void setExplain(String explain){
        this.explain = explain;
    }

    public ExplainModel(String answer, String explain){
        this.answer = answer;
        this.explain = explain;
    }
}
