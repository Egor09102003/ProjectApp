package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Questionnaire_5_6 extends AppCompatActivity {

    int answer1 = 0;
    int answer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire56);
    }

    public void yesButton(View view) {
        answer2 = 1;
    }

    public void noButton(View view) {
        answer2 = 2;
    }

    public void btn1(View view) {
        answer1 = 1;
    }

    public void btn2(View view) {
        answer1 = 2;
    }

    public void btn3(View view) {
        answer1 = 3;
    }

    public void startCheck(View view) {
        if (answer1 != 0 && answer2 != 0) {
            Intent intent = new Intent(this, Questionnaire_7_8.class);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }
    }
}