package com.nsibandelh.basicviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
{
    //Checkbox
    private CheckBox chkAutoSave;

    //RadioGroup
    private RadioGroup rBtnGroup;
    private RadioButton rbtn1;

    //ProgressBar
    static int iProgress;
    ProgressBar progressBar;
    int iProgressStatus = 0;
    Handler handler = new Handler();

    //Image Button
    private ImageButton imgBtnSubmit;

    //Thread
    private  Thread thread;

    //AutoCompleteTextView
    String[] sPresidents =
            {
                    "Dwight D. Eisenhower",
                    "John F. Kennedy",
                    "Lyndon B. Johnson",
                    "Richard Nixon",
                    "Gerald Ford",
                    "Jimmy Carter",
                    "Ronald Reagan",
                    "George H. W. Bush",
                    "Bill Clinton",
                    "George W. Bush",
                    "Barack Obama",
                    "Donald Trump"
            };

    private AutoCompleteTextView actxtPresidents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Checkbox
        chkAutoSave = (CheckBox) findViewById(R.id.chkAutoSave);
        chkAutoSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (((CheckBox)v).isChecked())
                {

                }
                else
                {

                }
            }
        });

        //RadioGroup & RadioButton
        rBtnGroup = (RadioGroup) findViewById(R.id.rbtnGroup);
        rBtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
                if (rbtn1.isChecked())
                {

                }
            }
        });

        //ProgressBar
        iProgress = 0;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(1000);

        thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                //Control number of times the ProgressBar processes
                while (iProgressStatus < 1000)
                {
                    iProgressStatus = doSomeWork();

                    //invoke Runnable() class, to indicate progress
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //as it increments, make sure the progress of progressBar also increments
                            progressBar.setProgress(iProgressStatus);
                        }
                    });
                }

                //Handles progressBar to make sure progressBar disappears
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //Tell ProgressBar to disappear
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }

            private int doSomeWork()
            {
                try
                {
                    //Pause
                    Thread.sleep(100); //?

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace(); //?
                }

                return ++iProgress;
            }
        });

        imgBtnSubmit = (ImageButton) findViewById(R.id.imgBtnSubmit);
        imgBtnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!thread.isAlive())
                    startThread();

            }
        });


        //AutoCompleteTextView
        actxtPresidents = (AutoCompleteTextView) findViewById(R.id.actxtPresidents);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line, sPresidents);

        //How many letters does the user have to type for AutoComplete to take place
        actxtPresidents.setThreshold(3);

        actxtPresidents.setAdapter(adapter);
    }

    private void startThread()
    {
        thread.start();
    }
}