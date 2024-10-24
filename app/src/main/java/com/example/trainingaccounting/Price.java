package com.example.trainingaccounting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Price extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        ImageButton imageButton = findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Price.this, MainScreen.class);
                startActivity(intent);
            }
        });

        Button buttonShowDialog1 = findViewById(R.id.button1);
        buttonShowDialog1.setOnClickListener(view -> showDialog1());

        Button buttonShowDialog2 = findViewById(R.id.button2);
        buttonShowDialog2.setOnClickListener(view -> showDialog2());

        Button buttonShowDialog3 = findViewById(R.id.button3);
        buttonShowDialog3.setOnClickListener(view -> showDialog3());

        Button buttonShowDialog4 = findViewById(R.id.button4);
        buttonShowDialog4.setOnClickListener(view -> showDialog4());
    }

    private void showDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("БЕЗЛИМИТНЫЙ 1 месяц")
                .setMessage("Ожидайте звонка. Менеджер свяжется с Вами")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрыть диалог
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("БЕЗЛИМИТНЫЕ 3 месяца")
                .setMessage("Ожидайте звонка. Менеджер свяжется с Вами")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрыть диалог
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("БЕЗЛИМИТНЫЕ 12 месяцев")
                .setMessage("Ожидайте звонка. Менеджер свяжется с Вами")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("АКЦИЯ")
                .setMessage("Ожидайте звонка. Менеджер свяжется с Вами. Вопросы по поводу акции узнавайте по телефону +7-(8412)-20-08-65")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}