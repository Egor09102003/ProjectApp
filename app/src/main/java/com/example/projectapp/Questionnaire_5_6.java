package com.example.projectapp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Questionnaire_5_6 extends AppCompatActivity {

    int answer1 = 0;
    int answer2 = 0;
    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire56);

        String q34 = getIntent().getStringExtra("q34");
        res = q34;
    }

    public void yesButton(View view) {
        answer2 = 1;
        findViewById(R.id.button6).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button5).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void noButton(View view) {
        answer2 = 2;
        findViewById(R.id.button5).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button6).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn1(View view) {
        answer1 = 1;
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button7).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn2(View view) {
        answer1 = 2;
        findViewById(R.id.button7).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn3(View view) {
        answer1 = 3;
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button8).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void startCheck(View view) {
        if (answer1 != 0 && answer2 != 0) {
            Intent intent = new Intent(this, Questionnaire_7_8.class);
            if (answer2 == 1)
                res += " yes";
            else
                res += " no";
            if (answer1 == 1)
                res += " match";
            else{
                if (answer1 == 2)
                    res += " medium";
                else
                    res += " no_match";
            }
            intent.putExtra("q56", res);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }
    }
}