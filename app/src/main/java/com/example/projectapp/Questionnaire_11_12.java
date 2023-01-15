package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Questionnaire_11_12 extends AppCompatActivity {

    int answer1 = 0;
    int answer2 = 0;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire1112);

        CheckBox agreement = (CheckBox) findViewById(R.id.checkBox2);
        agreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    flag = true;
                }
            }
        });
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
        findViewById(R.id.button9).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button7).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void btn5(View view) {
        findViewById(R.id.button7).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button9).setBackgroundResource(R.drawable.warning_button_design_last);
        answer2 = 2;
    }

    public void startCheck(View view) {


        if (answer1 != 0 && answer2 != 0 && flag) {
            Intent intent = new Intent(this, SMOL.class);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ или не подтвердили согласие");
        }


    }

}