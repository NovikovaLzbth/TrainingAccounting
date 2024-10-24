package com.example.trainingaccounting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import SQLiteHelper.DatabaseHelper;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DatabaseHelper myDB = new DatabaseHelper(this);

        EditText usernameEditText = findViewById(R.id.editTextText);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText phoneEditText = findViewById(R.id.editTextPhone);
        Button registerButton = findViewById(R.id.button);
        ImageButton imageButton = findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(Registration.this, "Пожалуйста, введите логин", Toast.LENGTH_SHORT).show();
                    usernameEditText.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(Registration.this, "Пожалуйста, введите пароль", Toast.LENGTH_SHORT).show();
                    passwordEditText.requestFocus();
                    return;
                }

                boolean isInserted = myDB.insertData(username, password, email, phone);
                if (isInserted) {
                    Toast.makeText(Registration.this, "Успешная регистрация", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this, SplashActivityOne.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Registration.this, "Неуспешная регистрация", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
