package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.material.textfield.TextInputEditText;

public class Mailing extends AppCompatActivity {

    String res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailing);

        String q = getIntent().getStringExtra("smol");
        res = q;
    }

    public void startMain(View view) throws JSONException {
        String answer = ((TextInputEditText) findViewById(R.id.input1)).getText().toString();
        JSONObject big_json = new JSONObject(res);
        JSONObject images = new JSONObject();
        big_json.put("images", images);
        big_json.put("email", answer);
        if (!answer.isEmpty() && isEmailValid(answer)) {
            Intent intent = new Intent(this, Results.class);
            big_json.put("is_send_to_email", true);
            intent.putExtra("mailing", big_json.toString());
            startActivity(intent);
        } else if (answer.isEmpty()) {
            Intent intent = new Intent(this, Results.class);
            big_json.put("is_send_to_email", false);
            intent.putExtra("mailing", big_json.toString());
            startActivity(intent);
        }
        else {
            TextView textWarning = (TextView) findViewById(R.id.textViewError);
            textWarning.setText("Пожалуйста, введите корректный адрес");
        }

    }

    public boolean isEmailValid(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}