package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Result_activity extends AppCompatActivity {
    ImageView result_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result_view = findViewById(R.id.result_imgvw);

        int imageResource = getIntent().getIntExtra("imageResource", 0);
        ImageView imageView = findViewById(R.id.result_imgvw);
        imageView.setImageResource(imageResource);


    }
}