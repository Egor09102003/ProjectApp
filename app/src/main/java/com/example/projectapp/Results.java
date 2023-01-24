package com.example.projectapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.StringEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.BasicResponseHandler;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.HttpClients;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Results extends AppCompatActivity {

    String res = null;
    String id;
    public String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String q = getIntent().getStringExtra("mailing");
        res = q;

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                HttpClient httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost("http://deniskuzmin.hopto.org:8000/api/v1/compatibility_quiz/");
                httppost.setHeader("Content-type", "application/json");
                httppost.setHeader("Accept", "application/json");
                httppost.setEntity(new StringEntity(res, "UTF-8"));
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    String responseString = new BasicResponseHandler().handleResponse(response);
                    id = responseString;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                HttpClient httpclient = HttpClients.createDefault();
                HttpGet httpget = new HttpGet("http://deniskuzmin.hopto.org:8000/api/v1/compatibility_quiz/"+id+"/result");
                try {
                    HttpResponse response = httpclient.execute(httpget);
                    String responseString = new BasicResponseHandler().handleResponse(response);
                    data = responseString;
                } catch (IOException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject json_data = null;
                        try {
                            json_data = new JSONObject(data);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        TextView man = findViewById(R.id.textView_m);
                        TextView woman = findViewById(R.id.textView_w);
                        TextView compatibility = findViewById(R.id.textView14);
                        TextView business = findViewById(R.id.textView13);
                        try {
                            compatibility.setText((CharSequence) json_data.get("years_compatibility_str"));
                            business.setText((CharSequence) json_data.get("years_business_str"));
                            man.setText("Тип личности:\n"+(CharSequence) json_data.get("male_personality_desc")+"\nТип характера:\n"+(CharSequence) json_data.get("male_character_type")+"\n"+(CharSequence) json_data.get("male_character_desc"));
                            woman.setText("Тип личности:\n"+(CharSequence) json_data.get("female_personality_desc")+"\nТип характера:\n"+(CharSequence) json_data.get("female_character_type")+"\n"+(CharSequence) json_data.get("female_character_desc"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });



        System.out.println(data);
    }
    public void startMain(View view) {
        Intent intent = new Intent(this, Main_page.class);
        startActivity(intent);
    }
}