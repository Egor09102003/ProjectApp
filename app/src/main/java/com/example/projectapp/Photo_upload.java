package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Photo_upload extends AppCompatActivity {

    ImageView view;
    ImageView view2;
    ImageView view3;
    ImageView view4;
    ImageView view5;
    ImageView view6;
    int flag = 0;
    int cnt = 0;
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List<String> imagesEncodedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_upload);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        view = (ImageView) findViewById(R.id.test_view);
        view2 = (ImageView) findViewById(R.id.imageview7);
        view3 = (ImageView) findViewById(R.id.imageview10);
        view4 = (ImageView) findViewById(R.id.imageview13);
        view5 = (ImageView) findViewById(R.id.imageview14);
        view6 = (ImageView) findViewById(R.id.imageview15);
        ImageButton PickImage = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton PickImage2 = (ImageButton) findViewById(R.id.imageButton11);



        PickImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 0;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
            }
        });

        PickImage2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
            }
        });

    }

    public void startWarning(View view) {
        Intent intent = new Intent(this, Warning.class);
        startActivity(intent);
    }

    public void startQuestionnaire12(View view) {
        cnt = 2;
        if(cnt == 2) {
            Intent intent = new Intent(this, Questionnaire_1_2.class);
            startActivity(intent);
        }
        else{
            TextView textWarning = (TextView) findViewById(R.id.textView12);
            textWarning.setText("Пожалуйста, загрузите по 3 фотографии");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_MULTIPLE) {
            if(resultCode == Activity.RESULT_OK) {
                if(data.getClipData() != null) {
                    int count = data.getClipData().getItemCount(); //evaluate the count before the for loop --- otherwise, the count is evaluated every loop.
                    if(count == 3){
                        cnt += 1;
                        TextView textWarning = (TextView) findViewById(R.id.textView12);
                        textWarning.setText("");
                        Uri imageUri1 = data.getClipData().getItemAt(0).getUri();
                        Uri imageUri2 = data.getClipData().getItemAt(1).getUri();
                        Uri imageUri3 = data.getClipData().getItemAt(2).getUri();
                        try {
                            if(flag == 0) {
                                final InputStream imageStream1 = getContentResolver().openInputStream(imageUri1);
                                final Bitmap selectedImage1 = BitmapFactory.decodeStream(imageStream1);
                                view.setImageBitmap(selectedImage1);
                                final InputStream imageStream2 = getContentResolver().openInputStream(imageUri2);
                                final Bitmap selectedImage2 = BitmapFactory.decodeStream(imageStream2);
                                view2.setImageBitmap(selectedImage2);
                                final InputStream imageStream3 = getContentResolver().openInputStream(imageUri3);
                                final Bitmap selectedImage3 = BitmapFactory.decodeStream(imageStream3);
                                view3.setImageBitmap(selectedImage3);
                            }
                            else{
                                final InputStream imageStream1 = getContentResolver().openInputStream(imageUri1);
                                final Bitmap selectedImage1 = BitmapFactory.decodeStream(imageStream1);
                                view4.setImageBitmap(selectedImage1);
                                final InputStream imageStream2 = getContentResolver().openInputStream(imageUri2);
                                final Bitmap selectedImage2 = BitmapFactory.decodeStream(imageStream2);
                                view5.setImageBitmap(selectedImage2);
                                final InputStream imageStream3 = getContentResolver().openInputStream(imageUri3);
                                final Bitmap selectedImage3 = BitmapFactory.decodeStream(imageStream3);
                                view6.setImageBitmap(selectedImage3);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        //do something with the image (save it to some directory or whatever you need to do with it here)
                    }
                    else{
                        TextView textWarning = (TextView) findViewById(R.id.textView12);
                        textWarning.setText("Пожалуйста, загрузите по 3 фотографии");
                    }
                }
            } else if(data.getData() != null) {
                String imagePath = data.getData().getPath();
                //do something with the image (save it to some directory or whatever you need to do with it here)
            }
        }
    }
}