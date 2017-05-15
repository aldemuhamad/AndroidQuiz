package com.example.aldemuhamad.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ExplainationActivity extends AppCompatActivity {

    private List<ExplainModel> ExplainModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExplainAdapter explainAdapter;
    private ExplainModel explainModel;

    Button btnTryAgain;
    Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaination);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        btnTryAgain= (Button) findViewById(R.id.mBtnTryAgain);
        btnQuit= (Button) findViewById(R.id.mBtnQuit);

        explainAdapter = new ExplainAdapter(getApplicationContext(), ExplainModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(explainAdapter);

        prepareData();

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tryAgain = new Intent(ExplainationActivity.this, StartActivity.class);
                startActivity(tryAgain);
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    void prepareData() {
        setExplain("Answer: A", "Google didirikan oleh Larry Page dan Sergey Brin saat masih mahasiswa Ph.D. di Universitas Stanford. Mereka berdua memegang 16 persen saham perusahaan. Mereka menjadikan Google sebagai perusahaan swasta pada tanggal 4 September 1998.");
        setExplain("Answer: D", "Yang bukan merupakan xml elemen pada android adalah WallpaperView");
        setExplain("Answer: B", "Untuk berpindah dari satu activity ke activity lain adalah Intent");
        setExplain("Answer: A", "Attribute untuk mengatur ukuran lebar pada sebuah elemen adalah layout_width");
        setExplain("Answer: C", "Google didirikan oleh Larry Page dan Sergey Brin saat masih mahasiswa Ph.D. di Universitas Stanford.");
    }

    void setExplain(String answer, String explain) {
        ExplainModel explainModel = new ExplainModel(answer, explain);
        ExplainModelList.add(explainModel);
    }

    public void onClick(View view) {
        Intent intent = new Intent(ExplainationActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
