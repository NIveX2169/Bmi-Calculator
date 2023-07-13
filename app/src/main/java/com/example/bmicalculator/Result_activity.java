package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {
    ImageView result_view;
    TextView  txtvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result_view = findViewById(R.id.result_imgvw);
        txtvw = findViewById(R.id.result_textvw);

        int imageResource = getIntent().getIntExtra("imageResource", 0);
        float bmi ;
        bmi = getIntent().getFloatExtra("BMI",0);

        result_view = findViewById(R.id.result_imgvw);
        txtvw.setText("Your BMI is "+ bmi);
        result_view.setImageResource(imageResource);



    }
}