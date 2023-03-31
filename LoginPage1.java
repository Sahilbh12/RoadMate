package com.example.internalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage1 extends AppCompatActivity {

    TextView lblLogin;
    EditText editTextEmail1;
    EditText editTextPassword1;
    Button buttonLogin;
    TextView lblSignup;
    FirebaseAuth auth;
    public static final String SHARED_PREFS = "sharedPrefs";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page1);

        rememberMe();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lblLogin = findViewById(R.id.lblLogin);
        editTextEmail1 = findViewById(R.id.txtLoginUsername);
        editTextPassword1 = findViewById(R.id.txtLoginPassword);
        buttonLogin = findViewById(R.id.btnlogin);
        lblSignup = findViewById(R.id.txtnuser);

        auth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(view -> {
            loginUser();
        });

        lblSignup.setOnClickListener(view -> {
            startActivity(new Intent(LoginPage1.this, SignupPage4.class));
        });


    }

    private void rememberMe() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check = sharedPreferences.getString("name", "");
        if (check.equals("true")){
            Toast.makeText(LoginPage1.this, "User login successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginPage1.this, HomePage2.class));
            finish();
        }
    }

    private void loginUser() {
        String email = editTextEmail1.getText().toString();
        String password = editTextPassword1.getText().toString();

        if (TextUtils.isEmpty(email)) {
            editTextEmail1.setError("Email cannot be empty !!");
            editTextEmail1.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            editTextPassword1.setError("Password cannot be empty !!");
            editTextPassword1.requestFocus();
        } else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name","true");
                        editor.apply();

                        Toast.makeText(LoginPage1.this, "User login successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage1.this, HomePage2.class));
                    } else {
                        Toast.makeText(LoginPage1.this, "Login Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage1.this, LoginPage1.class));
                    }
                }
            });
        }
    }


}
 /*private Button userlogin;
 Button userSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page1);

        userlogin = (Button) findViewById(R.id.btnlogin);
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage2();
            }
        });

        userSignup = (Button) findViewById(R.id.btnsignup);
        userSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupPage4();
            }
        });
    }
        public void openHomePage2() {
            Intent intent = new Intent(this,HomePage2.class);
            startActivity(intent);
    }
    public void openSignupPage4(){
        Intent intent = new Intent(this,SignupPage4.class);
        startActivity(intent);
    }
}*/
