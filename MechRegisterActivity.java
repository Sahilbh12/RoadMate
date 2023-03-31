package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MechRegisterActivity extends AppCompatActivity {

    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_register);
        signup = (Button) findViewById(R.id.mbtnSignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openLogin() {
        Intent intent = new Intent(this,MechLoginActivity.class);
        startActivity(intent);
    }
}