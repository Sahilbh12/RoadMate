package com.example.internalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView tpolice;
    private Button bpolice;
    private TextView tambulance;
    private Button bambulance;
    private TextView tfire;
    private Button bfire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        tpolice = findViewById(R.id.txtpolice);
        bpolice = findViewById(R.id.btnpolice);
        tambulance = findViewById(R.id.txtambulance);
        bambulance = findViewById(R.id.btnambulance);
        tfire = findViewById(R.id.txtfire);
        bfire = findViewById(R.id.btnfire);

        bambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callambulancebutton();
            }
        });
        bpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbutton();
            }
        });
        bfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfirebutton();
            }
        });
    }
    private void callfirebutton() {
        String number = tfire.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(HelpActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HelpActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void callambulancebutton() {
        String number = tambulance.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(HelpActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HelpActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void callbutton() {
        String number = tpolice.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(HelpActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HelpActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callbutton();
            } else {
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}