package com.example.trainingaccounting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import DATABASE.Databases;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Databases myDB = new Databases(this);
        CalendarView calendarView = findViewById(R.id.calendarView);
        RadioGroup radioGroup = findViewById(R.id.RadioGroup);
        Button buttonSave = findViewById(R.id.buttonSave);
        RadioGroup sportRadioGroup = findViewById(R.id.sportRadioGroup);
        ImageButton imageButton = findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SportInfoActivity.class);
                startActivity(intent);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long selectedDate = calendarView.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String date = sdf.format(new Date(selectedDate));

                int selectedId = radioGroup.getCheckedRadioButtonId();
                String time;

                if (selectedId == -1) {
                    Toast.makeText(SignUp.this, "Выберите время", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    time = selectedRadioButton.getText().toString(); // Получаем текст выбранного RadioButton
                }

                int selectedSportId = sportRadioGroup.getCheckedRadioButtonId();
                String sport;

                if (selectedSportId == -1) {
                    Toast.makeText(SignUp.this, "Выберите спорт", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    RadioButton selectedSportButton = findViewById(selectedSportId);
                    sport = selectedSportButton.getText().toString(); // Получаем текст выбранного RadioButton
                }

                // Проверяем, существует ли запись
                if (myDB.recordExists(date, time, sport)) {
                    Toast.makeText(SignUp.this, "Такая запись уже существует", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isInserted = myDB.insertData(date, time, sport);
                if (isInserted) {
                    Toast.makeText(SignUp.this, "Запись сохранена", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this, "Произошла ошибка при сохранении записи", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}