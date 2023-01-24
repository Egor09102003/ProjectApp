package com.example.projectapp;

import static android.util.Base64.DEFAULT;
import static android.util.Base64.encodeToString;
import static java.util.Base64.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

public class Results extends AppCompatActivity {

    String res = null;
    String id;
    public String data;
    String IMAGES;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String q = getIntent().getStringExtra("mailing");
        res = q;
        JSONArray male = new JSONArray();
        JSONArray female = new JSONArray();
        ArrayList<Bitmap> male_bit = Single.getMale();
        ArrayList<Bitmap> female_bit = Single.getFemale();
        for (int i = 0; i < 3; i++) {
            Bitmap bitmap_male = male_bit.get(i);
            Bitmap bitmap_female = female_bit.get(i);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap_male.compress(Bitmap.CompressFormat.PNG, 100, bytes);
            bitmap_female.compress(Bitmap.CompressFormat.PNG, 100, bytes);
            byte[] byteArr_male = bytes.toByteArray();
            byte[] byteArr_female = bytes.toByteArray();
            String encoded_male = encodeToString(byteArr_male, DEFAULT);
            String encoded_female = encodeToString(byteArr_female, DEFAULT);
            male.put(encoded_male);
            female.put(encoded_female);
        }
        JSONObject images = new JSONObject();
        try {
            images.put("male_images", male);
            images.put("female_images", female);
            JSONObject res_json = new JSONObject(res);
            res_json.put("images", images);
            res = res_json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(res);

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
                    System.out.println(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        JSONObject json_data = null;
                        try {
                            json_data = new JSONObject(data);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        TextView man_pers = findViewById(R.id.textView_m);
                        TextView woman_pers = findViewById(R.id.textView_w);
                        TextView man_char = findViewById(R.id.textView_m2);
                        TextView woman_char = findViewById(R.id.textView_w2);
                        TextView compatibility = findViewById(R.id.textView14);
                        TextView business = findViewById(R.id.textView13);
                        try {
                            compatibility.setText((CharSequence) json_data.get("years_compatibility_str"));
                            business.setText((CharSequence) json_data.get("years_business_str"));
                            man_pers.setText("Тип личности: " + (CharSequence) json_data.get("male_personality_type") + "\n" + (CharSequence) json_data.get("male_personality_desc"));
                            woman_pers.setText("Тип личности: " + (CharSequence) json_data.get("female_personality_type") + "\n" + (CharSequence) json_data.get("female_personality_desc"));
                            man_char.setText("Тип характера: " + (CharSequence) json_data.get("male_character_type") + "\n" + (CharSequence) json_data.get("male_character_desc"));
                            woman_char.setText("Тип характера: " + (CharSequence) json_data.get("female_character_type") + "\n" + (CharSequence) json_data.get("female_character_desc"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
    public void startMain(View view) {
        Intent intent = new Intent(this, Main_page.class);
        startActivity(intent);
    }
}