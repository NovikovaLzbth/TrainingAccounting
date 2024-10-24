package com.example.trainingaccounting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivityOne extends AppCompatActivity {
    private ProgressBar progressBar;
    private Handler handler = new Handler();
    private Runnable runnable;
    private int progressStatus = 0;

    public static int SplashTime = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splashactivityone);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivityOne.this, MainScreen.class);
                startActivity(intent);

                finish();

            }
        }, SplashTime);

        progressBar = findViewById(R.id.progressBar);

        // Запуск задания по обновлению прогресс-бара
        runnable = new Runnable() {
            @Override
            public void run() {
                if (progressStatus < 100) {
                    progressStatus++;
                    progressBar.setProgress(progressStatus);
                    handler.postDelayed(this, 10); // обновление каждые 10 мс
                }
            }

        };

        handler.post(runnable);

        // Остановка обновления через 3 секунды
        handler.postDelayed(() -> {
            handler.removeCallbacks(runnable);
        }, 3000);
    }
}