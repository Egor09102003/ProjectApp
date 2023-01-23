package com.example.projectapp;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Questionnaire_3_4 extends AppCompatActivity {

    int answer = 0;
  //  Resources resources = getResources();
   // int backgroundColor = resources.getColor(R.color.white,  null);
   // int textColor = resources.getColor(R.color.main_color,  null);
    String res = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire34);

        String q12 = getIntent().getStringExtra("q12");
        res = q12;
    }

    public void yes(View view) {
        answer = 1;
        findViewById(R.id.button3).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button2).setBackgroundResource(R.drawable.warning_button_design_last);
    }

    public void no(View view) {
        findViewById(R.id.button2).setBackgroundResource(R.drawable.click_button);
        findViewById(R.id.button3).setBackgroundResource(R.drawable.warning_button_design_last);
        answer = 2;
    }

    public void startCheck(View view) throws JSONException {
        String answer3 = ((EditText) findViewById(R.id.input3)).getText().toString();
        int num;
        if (answer3.isEmpty()) {
            num = -1;
        } else {
            num = Integer.parseInt(answer3);
        }
        System.out.println(answer);
        if (num < 50 && answer != 0 && num != -1) {
            JSONObject json = new JSONObject(res);
            json.put("age_difference", num);
            Intent intent = new Intent(this, Questionnaire_5_6.class);
            if (answer == 1)
                json.put("alcoholism", "yes");
            else
                json.put("alcoholism", "no");
            System.out.println(json);
            intent.putExtra("q34", json.toString());
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textView16);
            textWarning.setText("Введенные данные некорректны или Вы не выбрали ответ");
        }
    }
}