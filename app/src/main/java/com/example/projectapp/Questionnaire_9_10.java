package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Questionnaire_9_10 extends AppCompatActivity {

    int answer1 = 0;
    int answer2 = 0;
    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire910);

        String q78 = getIntent().getStringExtra("q78");
        res = q78;
    }

    public void btn1(View view) {
        answer1 = 1;
        findViewById(R.id.sometimes).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.never).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.always).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn2(View view) {
        answer1 = 2;
        findViewById(R.id.sometimes).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.always).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.never).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn3(View view) {
        answer1 = 3;
        findViewById(R.id.always).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.never).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.sometimes).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn4(View view) {
        answer2 = 1;
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button7).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn5(View view) {
        answer2 = 2;
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button7).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn6(View view) {
        answer2 = 3;
        findViewById(R.id.button8).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button7).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button8).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void startCheck(View view) {
        if (answer1 != 0 && answer2 != 0) {
            Intent intent = new Intent(this, Questionnaire_11_12.class);
            if (answer1 == 1)
                res += " own";
            else{
                if (answer1 == 2)
                    res += " not_own";
                else
                    res += " mortgage";
            }
            if (answer2 == 1)
                res += " always";
            else{
                if (answer2 == 2)
                    res += " sometimes";
                else
                    res += " never";
            }
            intent.putExtra("q910", res);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }
    }
}