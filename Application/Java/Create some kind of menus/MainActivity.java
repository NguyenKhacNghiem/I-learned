package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Contextual menu
    private ActionMode actionMode;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        // Chạy khi contextual menu được tạo ra (startActionMode() được gọi)
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_contextual, menu);

            return true;
        }

        // Chạy khi contextual menu xuất hiện
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        // Chạy khi người dùng chọn item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId() == R.id.item1) {
                showTitle(item.getTitle().toString());
                mode.finish(); // đã chọn item rồi thì đóng contextual menu

                return true;
            }

            if(item.getItemId() == R.id.item2) {
                showTitle(item.getTitle().toString());
                mode.finish(); // đã chọn item rồi thì đóng contextual menu

                return true;
            }

            return false;
        }

        // Chạy khi contextual menu bị đóng
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Context menu
        Button btnContext = findViewById(R.id.btnContext);
        registerForContextMenu(btnContext); // đăng ký context menu cho 1 view

        // Contextual menu
        Button btnContextual = findViewById(R.id.btnContextual);
        btnContextual.setOnLongClickListener(view -> {
            if (actionMode != null)
                return false;

            actionMode = MainActivity.this.startActionMode(actionModeCallback);
            view.setSelected(true);

            return true;
        });

        // Popup menu
        Button btnPopup = findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                if(item.getItemId() == R.id.item1) {
                    showTitle(item.getTitle().toString());
                    return true;
                }

                if(item.getItemId() == R.id.item2) {
                    showTitle(item.getTitle().toString());
                    return true;
                }

                return false;
            });

            popup.show();
        });
    }

    // test chức năng click của các item trên các menu
    public void showTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    // Option menu (trên thanh Action Bar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    // Select item trên option menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            showTitle(item.getTitle().toString());
            return true;
        }

        if(item.getItemId() == R.id.item2) {
            showTitle(item.getTitle().toString());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Chọn context menu để hiển thị cho button (vì có thể có tạo nhiều context mnu khác nhau nên phaải chọn)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    // Select item trên context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            showTitle(item.getTitle().toString());
            return true;
        }

        if(item.getItemId() == R.id.item2) {
            showTitle(item.getTitle().toString());
            return true;
        }

        return super.onContextItemSelected(item);
    }
}