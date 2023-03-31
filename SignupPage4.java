package com.example.internalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupPage4 extends AppCompatActivity
{
    TextView lblSignup;
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignup;
    TextView lbllogin;
    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page4);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lblSignup = findViewById(R.id.lblSignup);
        editTextEmail = findViewById(R.id.txtUsername);
        editTextPassword = findViewById(R.id.txtPassword);
        buttonSignup = findViewById(R.id.btnSignup);
        lbllogin = findViewById(R.id.lblLogin);

        auth = FirebaseAuth.getInstance();

        buttonSignup.setOnClickListener(view -> {
            createUser();
        });

        lbllogin.setOnClickListener(view -> {
            startActivity(new Intent(SignupPage4.this, LoginPage1.class));
        });
    }

    private void createUser() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(email)) {
            editTextEmail.setError("Email cannot be empty !!");
            editTextEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            editTextPassword.setError("Password cannot be empty !!");
            editTextPassword.requestFocus();
        }
        else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignupPage4.this,"User registred successfully!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupPage4.this, LoginPage1.class));
                    }
                    else {
                        Toast.makeText(SignupPage4.this,"Registration Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

