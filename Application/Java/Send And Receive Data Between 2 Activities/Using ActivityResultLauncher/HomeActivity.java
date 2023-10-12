package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Lấy ra Intent được gửi từ Main
        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        binding.tvEmail.setText("Xin chào, " + email + ". Vui lòng nhập tên");

        binding.btnSaveAndExit.setOnClickListener(v -> {
            Intent intent2 = new Intent();

            String name = binding.etName.getText().toString();
            intent2.putExtra("name", name);

            // Intent này là Intent trả về kết quả cho Intent trước đó, code để tương tác là RESULT_OK
            setResult(RESULT_OK, intent2);

            finish(); // start intent
        });
    }
}