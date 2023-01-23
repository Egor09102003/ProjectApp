package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Vector;


public class Questionnaire_12_M extends AppCompatActivity {

    int[] marks = new int[23];
    String answers = "[";
    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire12_m);

        String q11 = getIntent().getStringExtra("q11");
        res = q11;

        CheckBox agreement1 = (CheckBox) findViewById(R.id.checkBox1);
        agreement1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[0] = 1;
                }
                else {
                    marks[0] = 0;
                }
            }
        });

        CheckBox agreement2 = (CheckBox) findViewById(R.id.checkBox2);
        agreement2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[1] = 1;
                }
                else {
                    marks[1] = 0;
                }
            }
        });

        CheckBox agreement3 = (CheckBox) findViewById(R.id.checkBox3);
        agreement3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[2] = 1;
                }
                else {
                    marks[2] = 0;
                }
            }
        });

        CheckBox agreement4 = (CheckBox) findViewById(R.id.checkBox4);
        agreement4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[3] = 1;
                }
                else {
                    marks[3] = 0;
                }
            }
        });

        CheckBox agreement5 = (CheckBox) findViewById(R.id.checkBox5);
        agreement5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[4] = 1;
                }
                else {
                    marks[4] = 0;
                }
            }
        });

        CheckBox agreement6 = (CheckBox) findViewById(R.id.checkBox6);
        agreement6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[5] = 1;
                }
                else {
                    marks[5] = 0;
                }
            }
        });

        CheckBox agreement7 = (CheckBox) findViewById(R.id.checkBox7);
        agreement7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[6] = 1;
                }
                else {
                    marks[6] = 0;
                }
            }
        });

        CheckBox agreement8 = (CheckBox) findViewById(R.id.checkBox8);
        agreement8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[7] = 1;
                }
                else {
                    marks[7] = 0;
                }
            }
        });

        CheckBox agreement9 = (CheckBox) findViewById(R.id.checkBox9);
        agreement9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[8] = 1;
                }
                else {
                    marks[8] = 0;
                }
            }
        });

        CheckBox agreement10 = (CheckBox) findViewById(R.id.checkBox10);
        agreement10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[9] = 1;
                }
                else {
                    marks[9] = 0;
                }
            }
        });

        CheckBox agreement11 = (CheckBox) findViewById(R.id.checkBox11);
        agreement11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[10] = 1;
                }
                else {
                    marks[10] = 0;
                }
            }
        });

        CheckBox agreement12 = (CheckBox) findViewById(R.id.checkBox12);
        agreement12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[11] = 1;
                }
                else {
                    marks[11] = 0;
                }
            }
        });

        CheckBox agreement13 = (CheckBox) findViewById(R.id.checkBox13);
        agreement13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[12] = 1;
                }
                else {
                    marks[12] = 0;
                }
            }
        });

        CheckBox agreement14 = (CheckBox) findViewById(R.id.checkBox14);
        agreement14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[13] = 1;
                }
                else {
                    marks[13] = 0;
                }
            }
        });

        CheckBox agreement15 = (CheckBox) findViewById(R.id.checkBox15);
        agreement15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[14] = 1;
                }
                else {
                    marks[14] = 0;
                }
            }
        });

        CheckBox agreement16 = (CheckBox) findViewById(R.id.checkBox16);
        agreement16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[15] = 1;
                }
                else {
                    marks[15] = 0;
                }
            }
        });

        CheckBox agreement17 = (CheckBox) findViewById(R.id.checkBox17);
        agreement17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[16] = 1;
                }
                else {
                    marks[16] = 0;
                }
            }
        });

        CheckBox agreement18 = (CheckBox) findViewById(R.id.checkBox18);
        agreement18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[17] = 1;
                }
                else {
                    marks[17] = 0;
                }
            }
        });

        CheckBox agreement19 = (CheckBox) findViewById(R.id.checkBox19);
        agreement19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[18] = 1;
                }
                else {
                    marks[18] = 0;
                }
            }
        });

        CheckBox agreement20 = (CheckBox) findViewById(R.id.checkBox20);
        agreement20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[19] = 1;
                }
                else {
                    marks[19] = 0;
                }
            }
        });

        CheckBox agreement21 = (CheckBox) findViewById(R.id.checkBox21);
        agreement21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[20] = 1;
                }
                else {
                    marks[20] = 0;
                }
            }
        });

        CheckBox agreement22 = (CheckBox) findViewById(R.id.checkBox22);
        agreement22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[21] = 1;
                }
                else {
                    marks[21] = 0;
                }
            }
        });

        CheckBox agreement23 = (CheckBox) findViewById(R.id.checkBox23);
        agreement23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    marks[22] = 1;
                }
                else {
                    marks[22] = 0;
                }
            }
        });
    }

    public void startCheck(View view) throws JSONException {
        JSONArray answers = new JSONArray();
        int cnt = 0;
        for (int i = 0; i < 23; i ++) {
            cnt += marks[i];
            if (marks[i] != 0)
                answers.put(i);
        }
        if (cnt == 3 || cnt == 4 || cnt == 5) {
            Intent intent = new Intent(this, Questionnaire_12_W.class);
            JSONObject json = new JSONObject(res);
            json.put("economy_sector_male", answers);
            System.out.println(json);
            intent.putExtra("q12m", json.toString());
            startActivity(intent);
        } else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Пожалуйста, выберите 3-5 вариантов");
        }
    }
}