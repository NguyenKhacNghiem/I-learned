package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.exercise2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Write internal
        binding.btnWriteInternal.setOnClickListener(view -> {
            writeInternal();
        });

        // Read internal
        binding.btnReadInternal.setOnClickListener(view -> {
            readInternal();
        });

        // Write external
        binding.btnWriteExternal.setOnClickListener(view -> {
            writeExternal();
        });

        // Read external
        binding.btnReadExternal.setOnClickListener(view -> {
            readExternal();
        });
    }

    public void writeInternal() {
        Context context = getApplicationContext();
        String data = binding.etInput.getText().toString();

        try {
            FileOutputStream fileOutputStream = context.openFileOutput("internal.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();

            binding.etInput.setText("");
            Toast.makeText(this, "Write internal successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInternal() {
        try {
            Context context = getApplicationContext();
            FileInputStream fileInputStream = context.openFileInput("internal.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }

            fileInputStream.close();

            String fileContents = stringBuilder.toString();
            fileContents = fileContents.trim().replaceAll("\\n$", "");

            binding.etInput.setText(fileContents);
            Toast.makeText(this, "Read internal successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeExternal() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(externalStorageDir, "external.txt");

            try {
                FileOutputStream fos = new FileOutputStream(file);
                String data = binding.etInput.getText().toString();

                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Write external successfully!", Toast.LENGTH_SHORT).show();
                binding.etInput.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            Toast.makeText(this, "External storage is not available", Toast.LENGTH_SHORT).show();
    }

    public void readExternal() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(externalStorageDir, "external.txt");

            if (file.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder data = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null)
                        data.append(line).append("\n");

                    br.close();
                    isr.close();
                    fis.close();

                    String fileContents = data.toString();
                    fileContents = fileContents.trim().replaceAll("\\n$", "");
                    binding.etInput.setText(fileContents);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "External storage is not available", Toast.LENGTH_SHORT).show();
    }
}