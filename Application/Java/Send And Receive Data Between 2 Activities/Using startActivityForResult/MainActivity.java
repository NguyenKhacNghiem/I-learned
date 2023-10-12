package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int REQUEST_CODE = 1;

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

            // start Intent này nhưng có mong muốn nhận lại được kết quả trả về
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    // Sự kiện này sẽ được chạy khi có kết quả trả về từ Activity khác
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE) { // là Activity Home
            if(resultCode == RESULT_OK) {
                if(data != null) {
                    String name = data.getStringExtra("name");
                    binding.etEmail.setText(name);

                    binding.tvWelcome.setText("Hẹn gặp lại");
                    binding.btnLogin.setVisibility(View.GONE);
                }
            }
        }
    }
}