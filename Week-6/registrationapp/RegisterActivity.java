package com.example.registrationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editName;
    EditText editEmail;
    EditText editPassword;

    Button btnRegister;
    Button btnBack;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        // Initialize views
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);

        // Database object
        databaseHelper = new DatabaseHelper(this);

        // Register button
        btnRegister.setOnClickListener(view -> {

            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (name.isEmpty() ||
                    email.isEmpty() ||
                    password.isEmpty()) {

                Toast.makeText(
                        RegisterActivity.this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            boolean result =
                    databaseHelper.insertUser(
                            name,
                            email,
                            password
                    );

            if (result) {

                Toast.makeText(
                        RegisterActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                        RegisterActivity.this,
                        "Email already registered",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Back button
        btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}