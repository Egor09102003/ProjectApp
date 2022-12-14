package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Questionnaire_1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_questionnaire12);
    }

    public void startCheck(View view) {
        String answer1 = ((EditText) findViewById(R.id.input1)).getText().toString();
        Integer num1 = Integer.parseInt(answer1);
        String answer2 = ((EditText) findViewById(R.id.input2)).getText().toString();
        Integer num2 = Integer.parseInt(answer2);

        if(num1 < 60 & num2 < 100) {
            Intent intent = new Intent(this, Questionnaire_3_4.class);
            startActivity(intent);
        }
        else {
            TextView textWarning = (TextView) findViewById(R.id.textView11);
            textWarning.setText("Введенные данные некорректны");
        }


    }


}