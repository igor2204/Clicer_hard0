package com.example.clicerhard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        // Получение результата из предыдущей активности
        String result = getIntent().getStringExtra(MainActivity.KEY_RESULT);

        // Отображение результата на экране
        TextView resultTextView = findViewById(R.id.resultTextView);




        resultTextView.setText(result);



        }
}


