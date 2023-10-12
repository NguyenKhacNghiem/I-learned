package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    // Đăng ký sự kiện để nhận lại được kết quả trả về từ Activity Home
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();

                    if(data != null) {
                        String name = data.getStringExtra("name");
                        binding.etEmail.setText(name);

                        binding.tvWelcome.setText("Hẹn gặp lại");
                        binding.btnLogin.setVisibility(View.GONE);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            // Intent dùng để gửi dữ liệu từ Main sang Home và có truyền email qua
            Intent intent = new Intent(this, HomeActivity.class);

            String email = binding.etEmail.getText().toString();
            intent.putExtra("email", email);

            // start Intent này nhưng có mong muốn nhận lại được kết quả trả về từ Home
            launcher.launch(intent);
        });
    }
}