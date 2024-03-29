package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class Questionnaire_11_12 extends AppCompatActivity {

    int answer1 = 0;
    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire1112);

        String q910 = getIntent().getStringExtra("q910");
        res = q910;
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

    public void startCheck(View view) throws JSONException {
        if (answer1 != 0) {
            JSONObject json = new JSONObject(res);
            if (answer1 == 1)
                json.put("exchange_ideas", "Всегда");
            else if (answer1 == 2)
                json.put("exchange_ideas", "Нет");
            else
                json.put("exchange_ideas", "Иногда");
            Intent intent = new Intent(this, Questionnaire_12_M.class);
            System.out.println(json);
            intent.putExtra("q11", json.toString());
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Вы не выбрали ответ");
        }


    }

}