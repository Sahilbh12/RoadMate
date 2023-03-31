package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MechTodoActivity extends AppCompatActivity {
    private Button bmain;
    private Button btow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_todo);

        bmain = (Button) findViewById(R.id.btnmain);
        btow = (Button) findViewById(R.id.btntow);

        bmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openMechMain();}
        });
        btow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openMechTow();}
        });
    }
    private void openMechMain() {
        Intent intent = new Intent(this, MechMaintainActivity.class);
        startActivity(intent);
    }
    private void openMechTow(){
        Intent intent = new Intent(this, MechTowingActivity.class);
        startActivity(intent);
    }
}