package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    public void yes(View view) {
        Intent intent = new Intent(this, SMOL.class);
        startActivity(intent);
    }

    public void no(View view) {
        Intent intent = new Intent(this, MBTI.class);
        startActivity(intent);
    }
}