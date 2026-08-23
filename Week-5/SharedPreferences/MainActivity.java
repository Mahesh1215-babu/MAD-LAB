package com.example.sharedpreferencesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editAge;
    EditText editGender;

    Button btnSave;
    TextView textDisplay;

    SharedPreferences sharedPreferences;

    private static final String PREF_NAME = "UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initialize views
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editGender = findViewById(R.id.editGender);

        btnSave = findViewById(R.id.btnSave);
        textDisplay = findViewById(R.id.textDisplay);

        // Create SharedPreferences
        sharedPreferences = getSharedPreferences(
                PREF_NAME,
                MODE_PRIVATE
        );

        // Load previously saved data
        loadUserData();

        // Save button click
        btnSave.setOnClickListener(view -> {
            saveUserData();
        });
    }

    private void saveUserData() {

        String name = editName.getText().toString().trim();
        String age = editAge.getText().toString().trim();
        String gender = editGender.getText().toString().trim();

        // Save data
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name", name);
        editor.putString("Age", age);
        editor.putString("Gender", gender);

        editor.apply();

        // Display saved information
        textDisplay.setText(
                "Saved Information:\n\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender
        );
    }

    private void loadUserData() {

        String name = sharedPreferences.getString(
                "Name",
                ""
        );

        String age = sharedPreferences.getString(
                "Age",
                ""
        );

        String gender = sharedPreferences.getString(
                "Gender",
                ""
        );

        // If data exists, display it
        if (!name.isEmpty() || !age.isEmpty() || !gender.isEmpty()) {

            // Put saved values back into EditTexts
            editName.setText(name);
            editAge.setText(age);
            editGender.setText(gender);

            textDisplay.setText(
                    "Loaded Information:\n\n" +
                    "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Gender: " + gender
            );
        }
    }
}