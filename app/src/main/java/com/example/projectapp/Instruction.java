package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Instruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void startMain(View view) {
        Intent intent = new Intent(this, Main_page.class);
        startActivity(intent);
    }
}