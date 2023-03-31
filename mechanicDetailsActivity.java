package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mechanicDetailsActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private TextView tGan;
    private Button bGan;

    private TextView tA1;
    private Button bA1;

    private TextView tPappu;
    private Button bPappu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_details);
        tGan = findViewById(R.id.textGan);
        bGan = findViewById(R.id.btnGan);

        tA1 = findViewById(R.id.txtA1);
        bA1 = findViewById(R.id.btnA1);

        tPappu = findViewById(R.id.txtPappu);
        bPappu = findViewById(R.id.btnPappu);

        bGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {callGanButton();}
        });

        bA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {callA1Button();}
        });

        bPappu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {callPappuButton();}
        });

    }
    private void callGanButton() {
        String number = tGan.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(mechanicDetailsActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(mechanicDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callA1Button() {
        String number = tA1.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(mechanicDetailsActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(mechanicDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callPappuButton() {
        String number = tPappu.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(mechanicDetailsActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(mechanicDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }

    }
}