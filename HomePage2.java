package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage2 extends AppCompatActivity {
    private Button maintaince;
    private Button towing;
    private Button helpline;
    private Button logout;
    public static final String SHARED_PREFS = "sharedPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        maintaince = (Button) findViewById(R.id.btnmaintaince);
        helpline = (Button) findViewById(R.id.btnhelpline);
        logout = (Button) findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelplinePage();
            }
        });

        maintaince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaintaincePage();
            }
        });

        towing = (Button)findViewById(R.id.btntowing);
        towing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTowingPage5();
            }
        });
    }

    private void openHelplinePage() {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void openMaintaincePage() {
        Intent intent = new Intent(this, MaintaincePage3.class);
        startActivity(intent);
    }
    public void openTowingPage5(){
        Intent intent = new Intent(this,TowingPage5.class);
        startActivity(intent);
    }
    private void openLoginPage() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","");
        editor.apply();
        Intent intent = new Intent(this, LoginPage1.class);
        startActivity(intent);
    }
}