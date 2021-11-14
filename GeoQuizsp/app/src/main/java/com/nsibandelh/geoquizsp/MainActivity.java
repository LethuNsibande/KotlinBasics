package com.nsibandelh.geoquizsp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView lblQuestion;
    private Button btnTrue, btnFalse, btnNext;

    private Question[] QuestionBank = new Question[]
            {
                    new Question(R.string.question_africa, true),
                    new Question(R.string.question_americas, false),
                    new Question(R.string.question_asia, true),
                    new Question(R.string.question_mideast, false),
                    new Question(R.string.question_oceans, true)
            };

    private int iCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        //Update Question
        updateQuestion();

        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (questionTrue())
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
            }
        });

        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!questionTrue())
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
            }
        });

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                iCurrentIndex++;
                if (iCurrentIndex >= QuestionBank.length)
                {
                    iCurrentIndex = 0;
                    updateQuestion();
                }
                else
                    updateQuestion();
            }
        });
    }

    private void updateQuestion()
    {
        int iQuestion = QuestionBank[iCurrentIndex].getiQuestionId();
        lblQuestion.setText(iQuestion);
    }

    private boolean questionTrue()
    {
        return QuestionBank[iCurrentIndex].isbIsQuestionTrue();
    }
}