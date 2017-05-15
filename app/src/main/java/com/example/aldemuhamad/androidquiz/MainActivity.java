package com.example.aldemuhamad.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextNameParticipant;
    TextView mTextQuestionNum;
    TextView mTextQuestion;
    Button mBtnSubmit;
    RadioGroup optionGroup;
    RadioButton optionA, optionB,optionC,optionD;
    List<QuizModel> quizModelList = new ArrayList<>();
    int no = 0;
    int mScore = 0;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextNameParticipant = (TextView) findViewById(R.id.mTextNameParticipant);
        mTextQuestionNum = (TextView) findViewById(R.id.mTextQuestionNum);
        mTextQuestion = (TextView) findViewById(R.id.mTextQuestion);
        mBtnSubmit = (Button) findViewById(R.id.mBtnSubmit);
        optionGroup = (RadioGroup) findViewById(R.id.optionGroup);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);
        prepareData();
        setData();

        String participantname = getIntent().getStringExtra("name");
        mTextNameParticipant.setText(participantname);

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(no<quizModelList.size()) {
                    checkAnswer();
                    no++;
                }
                if(no<quizModelList.size()) {
                    setData();
                }
                if(no==quizModelList.size()){
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("score", mScore);
                    intent.putExtra("name", mTextNameParticipant.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    //digunakan untuk menset soal
    void prepareData(){
        setQuestion("1", "Pada tahun berapa google didirikan?", "1998", "2006", "1976", "2003", "A");
        setQuestion("2", "Dibawah ini adalah elemen pada xml android, kecuali..", "ImageView", "Button", "TextView", "WallpaperView", "D");
        setQuestion("3", "Untuk berpindah dari satu activity ke activity lain dapat menggunakan perintah?", "Move", "Intent", "Change", "Link", "B");
        setQuestion("4", "Attribute apa yang digunakan untuk mengatur lebar dari sebuah elemen?", "layout_width", "layout_height", "layout_padding", "layout_margin", "A");
        setQuestion("5", "Siapakah salah satu pendiri google?", "Steve Aoki", "Steve Jobs", "Larry Page", "John Sculley", "C");
    }

    void setData(){
        mTextQuestionNum.setText("Question " + quizModelList.get(no).getQuestionNum());
        mTextQuestion.setText(quizModelList.get(no).getQuestion());
        optionA.setText(quizModelList.get(no).getOptionA());
        optionB.setText(quizModelList.get(no).getOptionB());
        optionC.setText(quizModelList.get(no).getOptionC());
        optionD.setText(quizModelList.get(no).getOptionD());
    }

    void checkAnswer(){
        int index =0;
        switch (quizModelList.get(no).getAnswer()){
            case "A":
                index =0;
                break;
            case "B":
                index =1;
                break;
            case "C":
                index =2;
                break;
            case "D":
                index =3;
                break;
            default:index=0; break;
        }

        int selectedAnsewer = optionGroup.indexOfChild(findViewById(optionGroup.getCheckedRadioButtonId()));
        if(index == selectedAnsewer){
            mScore = mScore + 20;
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Salah", Toast.LENGTH_SHORT).show();
        }
    }

    //fungsi untuk mengeset soal ke model yang kemudian akan dimasukan ke modellist
    void setQuestion(String questionnum ,String question, String optionA, String optionB, String optionC, String optionD, String answer){
        QuizModel quizModel = new QuizModel(questionnum, question, optionA, optionB, optionC, optionD, answer);
        quizModelList.add(quizModel);
    }
}