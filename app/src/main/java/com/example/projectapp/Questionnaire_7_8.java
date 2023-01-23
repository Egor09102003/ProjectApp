package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class Questionnaire_7_8 extends AppCompatActivity {

    int answer = 0;
    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire78);

        String q56 = getIntent().getStringExtra("q56");
        res = q56;
    }

    public void level1(View view) {
        answer = 1;
        findViewById(R.id.button6).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button5).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void level2(View view) {
        answer = 2;
        findViewById(R.id.button5).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button6).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void startCheck(View view) throws JSONException {
        String answer1 = ((EditText) findViewById(R.id.answer1)).getText().toString();
        Integer num1 = -1;
        if (!answer1.isEmpty()) {
            num1 = Integer.parseInt(answer1);
        }
        String answer2 = ((EditText) findViewById(R.id.answer2)).getText().toString();
        Integer num2 = -1;
        if (!answer2.isEmpty()) {
            num2 = Integer.parseInt(answer2);
        }
        if (answer != 0 && num1 != -1 && num2 != -1) {
            Intent intent = new Intent(this, Questionnaire_9_10.class);
            JSONObject json = new JSONObject(res);
            json.put("salary_male", num1);
            json.put("salary_female", num2);
            if (answer == 1)
                json.put("education_level", "Совпадают");
            else
                json.put("education_level", "Не совпадают");
            intent.putExtra("q78", json.toString());
            System.out.println(json);
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Введенные данные некорректны или Вы не выбрали ответ");
        }
    }
}