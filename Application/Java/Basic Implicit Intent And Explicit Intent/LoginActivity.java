package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    Button button;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Lấy dữ liệu được gửi từ activity main qua
        // Lấy intent bên activity main
        intent = getIntent();

        // Lấy dữ liệu dạng String có trong Intent
        String name = intent.getStringExtra("name");

        tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        button = findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            // Explicit Intent giúp chuyển từ activity hiện tại (this) sang MainActivity
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}