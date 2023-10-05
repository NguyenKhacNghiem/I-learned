package com.example.a520h0557;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a520h0557.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);

            // Lấy email từ EditText để bỏ vào Intent gửi qua cho HomeActivity
            String email = binding.etEmail.getText().toString();
            intent.putExtra("email", email);

            // Thay vì start HomeActivity như bình thường thì sẽ start nó lên nhưng sẽ mong muốn nhận được kết quả trả về từ nó
            startActivityForResult(intent, 1);  // 1 là request code (mã chung để 2 Activity này dựa vào để biết nhau)
        });
    }

    // Khi HomeActivity trả kết quả ngược về thì sự kiện này sẽ được chạy
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) { // kiểm tra xem có phải MainActivity và HomeActivity có "hẹn" trước đó không
            if(resultCode == RESULT_OK) { // kiểm tra xem có phải kết quả là ok không (result code)
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