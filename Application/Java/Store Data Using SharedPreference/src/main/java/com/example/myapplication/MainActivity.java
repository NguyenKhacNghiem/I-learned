package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Lấy dữ liệu trong SharedPreferences
        String textColor = getTextColorFromSharedPreferences();
        String backgroundColor = getBackgroundColorFromSharedPreferences();

        changeColor(textColor, backgroundColor);

        // Hiển thị số lần mở app
        int count = getOpenCount();
        binding.tvNumber.setText(String.valueOf(count));

        // Tăng số lần mở app
        saveOpenCount(count);

        binding.btnSave.setOnClickListener(view -> {
            saveColorsToSharedPreferences(binding.etTextColor.getText().toString(), binding.etBackgroundColor.getText().toString());
        });
    }

    private void saveColorsToSharedPreferences(String textColor, String backgroundColor) {
        editor.putString("textColor", textColor);
        editor.putString("backgroundColor", backgroundColor);

        editor.apply();

        Toast.makeText(this, "Your colors have been saved!", Toast.LENGTH_SHORT).show();
        changeColor(textColor, backgroundColor);
    }

    private void saveOpenCount(int count) {
        editor.putInt("openCount", count + 1);
        editor.apply();
    }

    private String getTextColorFromSharedPreferences() {
        return sharedPreferences.getString("textColor", "#000000"); // Mặc định là màu đen (#000000) nếu không tìm thấy giá trị
    }

    private String getBackgroundColorFromSharedPreferences() {
        return sharedPreferences.getString("backgroundColor", "#FFFFFF"); // Mặc định là màu trắng (#FFFFFF) nếu không tìm thấy giá trị
    }

    private int getOpenCount() {
        return sharedPreferences.getInt("openCount", 1);
    }

    private void changeColor(String textColor, String backgroundColor) {
        // Thay đổi TextView
        binding.tvNumber.setTextColor(Color.parseColor(textColor));
        binding.tvNumber.setBackgroundColor(Color.parseColor(backgroundColor));

        // Hiển thị trên 2 EditText
        binding.etTextColor.setText(textColor);
        binding.etBackgroundColor.setText(backgroundColor);
    }
}