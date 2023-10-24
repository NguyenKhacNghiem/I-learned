package com.example.taskbackgroundusingexecutorservice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private String url = "https://media.wired.com/photos/594d820ea759c421820b833c/16:9/w_2400,h_1350,c_limit/AngryBirdsTA.jpg";
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);

        // 10 thread làm 10 task. Làm cùng lúc đc nhưng dễ lag máy
        // ExecutorService service = Executors.newFixedThreadPool(10)

        // 1 thread làm 1 task
        ExecutorService service = Executors.newSingleThreadExecutor();

        // Thực hiện công việc này ở background
        service.execute(() -> {
            Bitmap bitmap = NetworkUtil.fetchImage(url);

            // Chạy task này trên main thread để load image đã được fetch lên UI sau khi task ở background đã hoàn thành
            runOnUiThread(() -> {
                if(bitmap != null)
                    image.setImageBitmap(bitmap);
                else
                    Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT).show();
            });
        });
    }
}