package com.example.android.labwork_2_1_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private ListView listView;
    private String[] designPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        designPattern = getResources().getStringArray(R.array.design_patterns);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, designPattern);
        listView.setAdapter(adapter);
        registerForContextMenu(listView); // Привязываем контекстное меню к listView

    }

    // Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.upDate:
                Log.d("myLogs", "UPDATE !!!");
                return true;

            case R.id.delete:
                Log.d("myLogs", "DELETE !!!");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}