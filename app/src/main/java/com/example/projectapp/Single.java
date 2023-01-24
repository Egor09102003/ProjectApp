package com.example.projectapp;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Single {
    public static ArrayList<Bitmap> male = new ArrayList<>();
    public static ArrayList<Bitmap> female = new ArrayList<>();

    public static ArrayList<Bitmap> getMale(){
        return male;
    }
    public static ArrayList<Bitmap> getFemale(){
        return female;
    }

    public static void setMale(ArrayList<Bitmap> male) { Single.male = male; }
    public static void setFemale(ArrayList<Bitmap> female) { Single.female = female; }
}
