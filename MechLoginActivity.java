package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MechLoginActivity extends AppCompatActivity {

    private Button sig;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_login);
        sig = (Button) findViewById(R.id.MLbtnSignup);
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMechTodoPage();
;            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMSig();
            }
        });
    }
    public void openMSig(){
        Intent intent = new Intent(this,MechRegisterActivity.class);
        startActivity(intent);
    }
    private void openMechTodoPage() {
        Intent intent = new Intent(this,MechTodoActivity.class);
        startActivity(intent);
    }
}