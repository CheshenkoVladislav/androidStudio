package com.example.chesh.twoscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infoTextView;
    protected Button buttonChoose;

    public int CHOOSE_FILM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = findViewById(R.id.textViewerSecond);
        buttonChoose = findViewById(R.id.chooseButton);

        buttonChoose.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionIntent = new Intent(MainActivity.this,ChoooseActivity.class);

                startActivityForResult(questionIntent,CHOOSE_FILM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK){
                String filmName = data.getStringExtra(ChoooseActivity.Film);
                infoTextView.setText(filmName);
            }  else {
                infoTextView.setText(R.string.zero);
            }
        }
    }
