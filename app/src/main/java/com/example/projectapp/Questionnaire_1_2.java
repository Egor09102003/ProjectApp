package com.example.projectapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.android.material.textfield.TextInputLayout;

public class Questionnaire_1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_questionnaire12);
    }

    public void startCheck(View view) throws JSONException, IOException {
        String answer1 = ((EditText) findViewById(R.id.input1)).getText().toString();
        int num1;
        if (answer1.isEmpty()) {
            num1 = -1;
        } else {
            num1 = parseInt(answer1, 10);
        }

        String answer2 = ((EditText) findViewById(R.id.input2)).getText().toString();
        int num2;
        if (answer2.isEmpty()) {
            num2 = -1;
        } else {
            num2 = parseInt(answer2, 10);
        }

        if(num1 < 60 & num2 < 100 && num1 != -1 && num2 != -1) {
            Intent intent = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                intent = new Intent(this, Questionnaire_3_4.class);
            }
            String path = "data.json";
            JSONObject json = new JSONObject();
            json.put("height_difference", num1);
            json.put("weight_difference", num2);
            System.out.println(json);
            intent.putExtra("q12", json.toString());
            startActivity(intent);
        }
        else {
            TextView textWarning = (TextView) findViewById(R.id.textView11);
            textWarning.setText("Введенные данные некорректны");
        }
    }
}