package com.nsibandelh.pulsechecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private String[] modules = {"module 1", "module 2", "module 3", "module 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.modules_item_listview, R.id.textView, modules);

        listview.setAdapter(arrayAdapter);

        //Button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Intent
                Intent intent = new Intent(listview.getContext(), CheckListActivity.class);
                startActivity(intent);

            }
        });
    }




    //Play Music
    private void playSound()
    {
        MediaPlayer mediaPlayer = new MediaPlayer().create(this, R.raw.music);
        mediaPlayer.start();
    }
}