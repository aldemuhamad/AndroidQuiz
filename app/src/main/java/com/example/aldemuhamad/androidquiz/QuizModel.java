package com.example.aldemuhamad.androidquiz;

/**
 * Created by aldemuhamad on 5/13/2017.
 */

public class QuizModel {
    private String questionnum;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;

    public String getQuestionNum() {

        return questionnum;
    }
    public String getQuestion() {

        return question;
    }

    public String getOptionA() {

        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getAnswer() {
        return answer;
    }


    public QuizModel(String questionnum, String question, String optionA, String optionB, String optionC, String optionD, String answer) {
        this.questionnum = questionnum;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }
}

