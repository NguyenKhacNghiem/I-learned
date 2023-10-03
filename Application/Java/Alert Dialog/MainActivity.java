package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowAlert;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowAlert = findViewById(R.id.btnShowAlert);
        builder = new AlertDialog.Builder(this);

        btnShowAlert.setOnClickListener(view -> {
            builder.setTitle("Title");
            builder.setMessage("Message");

            builder.setCancelable(true);

            builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("No", (dialogInterface, i) -> {
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            });

            builder.show();
        });
    }
}