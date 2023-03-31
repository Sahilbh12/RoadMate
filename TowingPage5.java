package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TowingPage5 extends AppCompatActivity {
    private Button submit;
    private EditText etoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towing_page5);
        submit = (Button) findViewById(R.id.btnSubmit);
        etoast = (EditText) findViewById(R.id.editTotal);
        submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float dist = Float.parseFloat(etoast.getText().toString());
                float total = dist*100;
                Toast.makeText(getApplicationContext(),"AMOUNT TO BE PAID ₹ "+total,Toast.LENGTH_LONG).show();
                opeMechanicDetailsPage();
            }
        });
    }
    private void opeMechanicDetailsPage() {
        Intent intent = new Intent(this, mechanicDetailsActivity.class);
        startActivity(intent);
    }
}