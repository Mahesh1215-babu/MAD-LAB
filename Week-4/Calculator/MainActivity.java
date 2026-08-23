package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1;
    EditText editTextNumber2;

    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initialize views
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        textViewResult = findViewById(R.id.textViewResult);

        // Button click events
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {

        String num1Str = editTextNumber1.getText().toString().trim();
        String num2Str = editTextNumber2.getText().toString().trim();

        // Check whether both numbers are entered
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textViewResult.setText("Please enter both numbers");
            return;
        }

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter valid numbers");
            return;
        }

        double result;

        switch (operator) {

            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    textViewResult.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
                break;

            default:
                textViewResult.setText("Invalid operation");
                return;
        }

        textViewResult.setText("Result: " + result);
    }
}