package com.example.resource.roomapp.ui;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.resource.roomapp.infra.MyAppDataBase;
import com.example.resource.roomapp.R;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnSelect;
    public static MyAppDataBase myAppDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);


        myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "user").allowMainThreadQueries().build();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insertIntent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insertIntent);
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insertIntent = new Intent(MainActivity.this, ListarActivity.class);
                startActivity(insertIntent);
            }
        });


    }
}
