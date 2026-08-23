package com.example.candidatelistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listViewNames;

    String[] names = {
            "Alice",
            "Bob",
            "Charlie",
            "David"
    };

    String[] details = {
            "Name: Alice\nAge: 22\nQualification: B.Tech\nBranch: CSE",
            "Name: Bob\nAge: 23\nQualification: B.Tech\nBranch: ECE",
            "Name: Charlie\nAge: 22\nQualification: B.Tech\nBranch: IT",
            "Name: David\nAge: 24\nQualification: B.Tech\nBranch: Mechanical"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load MainActivity layout
        setContentView(R.layout.activity_main);

        // Initialize ListView
        listViewNames = findViewById(R.id.listViewNames);

        // Connect names array to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );

        listViewNames.setAdapter(adapter);

        // Handle name selection
        listViewNames.setOnItemClickListener((parent, view, position, id) -> {

            // Create Intent to open DetailActivity
            Intent intent = new Intent(
                    MainActivity.this,
                    DetailActivity.class
            );

            // Pass selected candidate details
            intent.putExtra("details", details[position]);

            // Open DetailActivity
            startActivity(intent);
        });
    }
}