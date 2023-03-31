package com.example.internalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MaintaincePage3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edittxtModel;
    private EditText edittxtNumber;
    private EditText location;
    private EditText problem;
    private Button search;
    private Spinner spinner;
    private Button submit;
    DatabaseReference vehiclesDBref;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintaince_page3);
        search = (Button) findViewById(R.id.button3);
        submit = (Button) findViewById(R.id.btnSubmit);
        location = (EditText)findViewById(R.id.txtLocation);
        edittxtModel = (EditText)findViewById(R.id.txtModel);
        edittxtNumber = (EditText) findViewById(R.id.txtNumber);
        problem = (EditText)findViewById(R.id.txtProblem);
        spinner = (Spinner) findViewById(R.id.drpdwnType);
        vehiclesDBref = FirebaseDatabase.getInstance().getReference().child("Vehicles");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMechanicDetails();
            }


        });

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapPage();
            }
        });
    }
    private void openMapPage() {
        Intent intent = new Intent(this, mapActivity.class);
        startActivity(intent);
    }
    private void openMechanicDetails() {
        String Location = location.getText().toString();
        String model = edittxtModel.getText().toString();
        String number = edittxtNumber.getText().toString();
        String Problem = problem.getText().toString();
        String vehicleType = spinner.getSelectedItem().toString();

        vehiclesDetailsSaver vehicles = new vehiclesDetailsSaver(Location, model, number, Problem, vehicleType);
        vehiclesDBref.push().setValue(vehicles);
        Toast.makeText(this, "Data saved successfully!!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, mechanicDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}