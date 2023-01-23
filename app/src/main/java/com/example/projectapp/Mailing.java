package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Mailing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailing);
    }

    public void startMain(View view) {
        String answer = ((TextInputEditText) findViewById(R.id.input1)).getText().toString();
        if ((!answer.isEmpty() && isEmailValid(answer)) || answer.isEmpty()) {
            Intent intent = new Intent(this, Results.class);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Пожалуйста, введите корректный адрес");
        }

    }

    public boolean isEmailValid(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}