package com.example.a520h0557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a520h0557.databinding.ActivityHomeBinding;
import com.example.a520h0557.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {
   ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Lấy Intent được gửi từ MainActivity
        Intent intent = getIntent();

        // Lấy email mà Intent này chứa
        String email = intent.getStringExtra("email");
        binding.tvEmail.setText("Xin chào, " + email + ". Vui lòng nhập tên");

        binding.btnSaveAndExit.setOnClickListener(v -> {
            // Tạo ra 1 Intent khác để trả kết quả ngược về cho MainActivity
            Intent intent2 = new Intent();

            String name = binding.etName.getText().toString();
            intent2.putExtra("name", name);

            // Bỏ Intent này vào hàm Result với result code là RESULT_OK (1 con số nguyên)
            setResult(RESULT_OK, intent2);

            finish(); // Hoàn thành Intent này
        });
    }
}