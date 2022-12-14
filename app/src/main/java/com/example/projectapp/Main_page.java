package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void startUpload(View view) {
        Intent intent = new Intent(this, Photo_upload.class);
        startActivity(intent);
    }

    public void startInstruction(View view) {
        Intent intent = new Intent(this, Instruction.class);
        startActivity(intent);
    }

    public void startFeedback(View view) {
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

}