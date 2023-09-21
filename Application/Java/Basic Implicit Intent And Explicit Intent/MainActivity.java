package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnWeb;
    Button btnPhone;
    Button btnSearch;
    EditText etInput;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnWeb = findViewById(R.id.btnWeb);
        btnPhone = findViewById(R.id.btnPhone);
        btnSearch = findViewById(R.id.btnSearch);
        etInput = findViewById(R.id.etInput);

        btnLogin.setOnClickListener(view -> {
            // Explicit Intent giúp chuyển từ activity hiện tại (this) sang LoginActivity
            intent = new Intent(this, LoginActivity.class);

            // Thêm dữ liệu vào Intent để gửi qua activity khác
            intent.putExtra("name", "Peter");

            startActivity(intent);
        });

        btnWeb.setOnClickListener(view -> {
            Uri uri = Uri.parse("http://www.google.com");
            intent = new Intent(Intent.ACTION_VIEW, uri); // mở 1 trang web

            startActivity(intent);
        });

        btnPhone.setOnClickListener(view -> {
            Uri uri = Uri.parse("tel:0703149783");
            intent = new Intent(Intent.ACTION_DIAL, uri); // mở ứng dụng điện thoại và điền sđt vô sẵn

            startActivity(intent);
        });

        btnSearch.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_WEB_SEARCH);

            String query = etInput.getText().toString();
            intent.putExtra(SearchManager.QUERY, query); // mở trình duyệt và search

            startActivity(intent);
        });
    }
}