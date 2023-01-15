package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Questionnaire_9_10 extends AppCompatActivity {

    int answer1 = 0;
    int answer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire910);
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

    public void btn4(View view) {
        answer2 = 1;
    }

    public void btn5(View view) {
        answer2 = 2;
    }

    public void btn6(View view) {
        answer2 = 3;
    }

    public void startCheck(View view) {
        if (answer1 != 0 && answer2 != 0) {
            Intent intent = new Intent(this, Questionnaire_11_12.class);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }
    }
}