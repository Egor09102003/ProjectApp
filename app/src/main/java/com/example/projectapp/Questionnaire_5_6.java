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
import org.json.JSONException;
import org.json.JSONObject;

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

    public void startCheck(View view) throws JSONException {
        if (answer1 != 0 && answer2 != 0) {
            Intent intent = new Intent(this, Questionnaire_7_8.class);
            JSONObject json = new JSONObject(res);
            if (answer2 == 1)
                json.put("political_views_difference", "yes");
            else
                json.put("political_views_difference", "no");
            if (answer1 == 1)
                json.put("leisure_preferences_coincide", "Совпадают");
            else{
                if (answer1 == 2)
                    json.put("leisure_preferences_coincide", "50/50");
                else
                    json.put("leisure_preferences_coincide", "Не совпадают");
            }
            System.out.println(json.toString());
            intent.putExtra("q56", json.toString());
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }
    }
}