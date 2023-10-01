package com.example.a520h0557;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.regex.*;


import com.example.a520h0557.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String input = "";
    String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Xử lý tính toán
        ViewGroup tlButtons = binding.tlButtons; // TableLayout
        for(int i = 0; i < tlButtons.getChildCount(); i++) {
            ViewGroup trButtons = (ViewGroup) tlButtons.getChildAt(i); // TableRow

            for(int j = 0; j < trButtons.getChildCount(); j++) {
                View btn = trButtons.getChildAt(j);

                btn.setOnClickListener(view -> {
                    String text = ((Button) btn).getText().toString();

                    if(text.equals("=")) {
                        // chuỗi regex khớp với các trường hợp: 1+8, 1.6+9.4,...
                        String regex = "([0-9]+(\\.[0-9]+)?)\\s*([+\\-x/])\\s*([0-9]+(\\.[0-9]+)?)";

                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(input);

                        if (matcher.matches()) {
                            double n1 = Double.parseDouble(matcher.group(1));
                            String op = matcher.group(3);
                            double n2 = Double.parseDouble(matcher.group(4));

                            if(op.equals("+"))
                                output = "=" + (n1 + n2);
                            else if(op.equals("-"))
                                output = "=" + (n1 - n2);
                            else if(op.equals("x"))
                                output = "=" + (n1 * n2);
                            else if(op.equals("/")) {
                                if(n2 == 0)
                                    output = "=ERROR";
                                else
                                    output = "=" + (n1 / n2);
                            }
                            else {
                                binding.tvResult.setText(input);
                                input = "";
                                return;
                            }

                            binding.tvResult.setText(input + output);
                            input = "";
                        }
                        else {
                            binding.tvResult.setText("ERROR");
                            input = "";
                            output = "";
                        }
                    }
                    else {
                        input += text;
                        binding.tvResult.setText(input);
                    }
                });
            }
        }

        // Set sự kiện cho nút xóa
        binding.ivRemove.setOnClickListener(view -> {
            input = "";
            output = "";
            binding.tvResult.setText("");
        });
    }
}