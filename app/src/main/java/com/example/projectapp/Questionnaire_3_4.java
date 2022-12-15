package com.example.projectapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Questionnaire_3_4 extends AppCompatActivity {

  //  int flag = 0;
  //  Resources resources = getResources();
   // int backgroundColor = resources.getColor(R.color.white,  null);
   // int textColor = resources.getColor(R.color.main_color,  null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire34);
    }

    //  public void startYes(View view) {
  //
  //  }

    public void startCheck(View view) {
        String answer3 = ((EditText) findViewById(R.id.input3)).getText().toString();
        Integer num = Integer.parseInt(answer3);

        if(num < 50) {
            Intent intent = new Intent(this, Questionnaire_5_6.class);
            startActivity(intent);
        }
        else {
            TextView textWarning = (TextView) findViewById(R.id.textView16);
            textWarning.setText("Введенные данные некорректны");
        }
    }
}