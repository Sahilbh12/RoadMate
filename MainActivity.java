package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button user;
    private Button mechanic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        user = (Button) findViewById(R.id.btnuser);
        mechanic = (Button) findViewById(R.id.btnMechanic);

        mechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMechanicLoginPage();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage1();
            }
        });
    }
    private void openMechanicLoginPage() {
        Intent intent = new Intent(this, MechLoginActivity.class);
        startActivity(intent);
    }
    public void openLoginPage1 () {
        Intent intent = new Intent(this, LoginPage1.class);
        startActivity(intent);
    }
}
