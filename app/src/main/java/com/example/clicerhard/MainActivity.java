package com.example.clicerhard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private int targetScore = 100;
    private boolean gameEnded = false;
    final static String KEY_RESULT = "result";

    private TextView textTime;

    private TextView numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView numberText = findViewById(R.id.number);
        TextView textTime = findViewById(R.id.textTimer);
        Button clickButton = findViewById(R.id.buttonclick);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameEnded) {
                    score += 5;  // Увеличить количество очков при нажатии кнопки
                    if (score >= targetScore) {
                        endGameWithMessage("Победа");
                        MediaPlayer play= MediaPlayer.create(MainActivity.this,R.raw.wictory);
                        play.start();
                    }
                }
                TextView numberText = findViewById(R.id.number);
                numberText.setText("Количество очков: " + score);
                MediaPlayer play= MediaPlayer.create(MainActivity.this,R.raw.punch);
                play.start();
            }
        });


        new CountDownTimer(30000, 1000) {
            public void onTick(long l) {
                textTime.setText(""+l/1000);

            }

            public void onFinish() {
                if (score < targetScore) {
                    endGameWithMessage("Поражение");
                    MediaPlayer play= MediaPlayer.create(MainActivity.this,R.raw.lose);
                    play.start();

                }
            }

        }.start();
    }

    private void endGameWithMessage(String message) {
        gameEnded = true;
        // Отправка сообщения о результате игры
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(KEY_RESULT, message);
        startActivity(intent);
    }
}















