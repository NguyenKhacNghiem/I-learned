package com.example.exercise3;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.result.ActivityResultLauncher;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvItem;
    private EventAdapter eventAdapter;
    private List<Event> events;
    private Intent intent;

    // Đăng ký sự kiện để nhận lại được kết quả trả về từ Activity Add
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();

                    if(data != null) {
                        Event event = data.getParcelableExtra("newEvent");
                        eventAdapter.addNewEvent(event);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        eventAdapter = new EventAdapter(this);
        rcvItem = findViewById(R.id.rcvEvent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvItem.setLayoutManager(linearLayoutManager);

        eventAdapter.setData();
        rcvItem.setAdapter(eventAdapter);

        // Đăng ký context menu cho các item trong RecyclerView
        registerForContextMenu(rcvItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Sự kiện check change cho Switch trên option menu
        MenuItem toggleItem = menu.findItem(R.id.option_toggle);
        Switch toggleSwitch = (Switch) toggleItem.getActionView();

        toggleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            eventAdapter.showHideEvent(isChecked);
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_removeAll:
                onClickShowAlert();
                return true;
            case R.id.option_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_add:
                intent = new Intent(this, AddActivity.class);
                launcher.launch(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickShowAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setTitle("Xác nhận xóa?");
        alertDialog.setMessage("Bạn có chắc muốn xóa không?");

        alertDialog.setPositiveButton("YES", (dialog, which) -> {
            eventAdapter.removeAll();
        });

        alertDialog.setNegativeButton("NO", (dialog, which) -> {

        });

        alertDialog.show();
    }
    
    // Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.context_edit) {
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(item.getItemId() == R.id.context_delete) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}