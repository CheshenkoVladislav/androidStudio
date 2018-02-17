package com.example.chesh.twoscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by chesh on 15.02.2018.
 */

public class ChoooseActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button button;

    public static String Film = "Film";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseactivity);

        radioGroup = findViewById(R.id.radio_group);
        button = findViewById(R.id.changeValue);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final Intent answerIntent = new Intent();

                switch (i){
                    case R.id.button1:
                        answerIntent.putExtra(Film,getResources().getString(R.string.film1));
                        break;
                    case R.id.button2:
                        answerIntent.putExtra(Film,getResources().getString(R.string.film2));
                        break;
                    case R.id.button3:
                        answerIntent.putExtra(Film,getResources().getString(R.string.film3));
                        break;
                    default:
                        break;


                }
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setResult(RESULT_OK,answerIntent);
                        finish();
                    }
                });
            }
        });


    }
}
