package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Results extends AppCompatActivity {

    String res = null;
    String smol = null;
    String mbti = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String q = getIntent().getStringExtra("q");
        res = q;
        String s = getIntent().getStringExtra("smol");
        smol = s;
        String s1 = getIntent().getStringExtra("mbti");
        mbti = s1;
        System.out.println(res);
        System.out.println(smol);
        System.out.println(mbti);
    }
    public void startMain(View view) {
        Intent intent = new Intent(this, Main_page.class);
        startActivity(intent);
    }
}