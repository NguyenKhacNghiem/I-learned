package com.example.exercise3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.exercise3.Event;
import com.example.exercise3.databinding.ActivityAddBinding;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    Intent intent;
    ActivityAddBinding binding;
    private static final String[] rooms ={"C201", "C202", "C203", "C204"};
    private int selectedRoom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set sự kiện click cho các EditText
        binding.etPlace.setOnClickListener(view -> {
            showPlacesDialog();
        });

        binding.etDate.setOnClickListener(view -> {
            showDatePicker();
        });

        binding.etTime.setOnClickListener(view -> {
            showTimePicker();
        });

        // Set sự kiện focus cho các EditText
        binding.etPlace.setOnFocusChangeListener((view, isFocus) -> {
            if(isFocus)
                showPlacesDialog();
        });

        binding.etDate.setOnFocusChangeListener((view, isFocus) -> {
            if(isFocus)
                showDatePicker();
        });

        binding.etTime.setOnFocusChangeListener((view, isFocus) -> {
            if(isFocus)
                showTimePicker();
        });

        // Hiện back button để trở về Main Activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_save:
                saveData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Trở về Main Activity đồng thời gửi event đã được thêm thông qua Parcelable
    private void saveData() {
        if (!isInputValid())
            return;

        String name = binding.etName.getText().toString();
        String place = binding.etPlace.getText().toString();
        String date = binding.etDate.getText().toString();
        String time = binding.etTime.getText().toString();

        // name: subject
        // place: room
        // date + " " + time: date
        Event event = new Event(name, place, date + " " + time);

        intent = new Intent();
        intent.putExtra("newEvent", event);

        setResult(RESULT_OK, intent);
        finish();
    }

    // Hiện dialog chọn room
    private void showPlacesDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Select Place");

        // Tạo radio button trong Alert Dialog
        alertDialog.setSingleChoiceItems(rooms, selectedRoom, (dialogInterface, i) -> {
            selectedRoom = i;

            String room = rooms[i];
            binding.etPlace.setText(room);

            dialogInterface.dismiss();
        });

        alertDialog.create();
        alertDialog.show();
    }

    // Hiện Date Picker
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, (datePicker, i, i1, i2) -> {
            String date = i2 + "/" +(i1 + 1) +"/" + i;
            binding.etDate.setText(date);
        }, year, month, day);

        dialog.show();
    }

    // Hiện Time Picker
    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(this, (timePicker, i, i1) -> {
            String time = i + ":" + i1;
            binding.etTime.setText(time);
        }, hour, minute, true);

        dialog.show();
    }

    private boolean isInputValid(){
        String name = binding.etName.getText().toString();
        String place = binding.etPlace.getText().toString();
        String date = binding.etDate.getText().toString();
        String time = binding.etTime.getText().toString();

        if(name.trim().isEmpty()){
            binding.tilName.setError("Please enter event name");
            return false;
        }

        if(place.trim().isEmpty()){
            binding.tilPlace.setError("Please select a room");
            return false;
        }

        if(date.trim().isEmpty()){
            binding.tilDate.setError("Please select event date");
            return false;
        }

        if(time.trim().isEmpty()){
            binding.tilTime.setError("Please select event time");
            return false;
        }

        return true;
    }
}