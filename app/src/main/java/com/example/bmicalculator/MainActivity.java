package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextView height,weight;
    Button calculatebtn;
    RadioGroup gender_rdgb;
    String gender;
    ImageView result_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height_et);
        weight = findViewById(R.id.weight_et);
        gender_rdgb = findViewById(R.id.gender_rg);
        calculatebtn = findViewById(R.id.calbtn);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String height_val = height.getText().toString();
                String weight_val = weight.getText().toString();

                if (height_val.isEmpty()&&weight_val.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Height(cm) and Weight(kg)", Toast.LENGTH_LONG).show();
                }else if (height_val.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Height in Cm ", Toast.LENGTH_LONG).show();
                }
                else if(weight_val.isEmpty()){
                            Toast.makeText(MainActivity.this, "Enter Weight in Kg ",Toast.LENGTH_LONG).show();

                } else {
                    try {
                        float height_float = Float.parseFloat(height_val);
                        float weight_float = Float.parseFloat(weight_val);
                        float bmi = calBmi(height_float, weight_float);


                        Intent intent = new Intent(MainActivity.this, Result_activity.class);
                        if ((bmi > 18.5) && (bmi < 24.9)) {
                            if (gender == "boy") {
                                intent.putExtra("imageResource", R.drawable.boy_normal);
                                intent.putExtra("BMI", bmi);
                            } else {
                                intent.putExtra("imageResource", R.drawable.girl_normal);
                                intent.putExtra("BMI", bmi);

                            }
                        } else {
                            if (gender == "boy") {
                                intent.putExtra("imageResource", R.drawable.boy_overweight);
                                intent.putExtra("BMI", bmi);

                            } else {
                                intent.putExtra("imageResource", R.drawable.girl_overweight);
                                intent.putExtra("BMI", bmi);

                            }
                        }
                        startActivity(intent);

                    } catch (Exception e)
                    {
                        Toast.makeText(MainActivity.this,"PLease Enter Details In Correct Format",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        gender_rdgb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == -1)
                {
                    Toast.makeText(MainActivity.this,"PLease Select Gender",Toast.LENGTH_SHORT).show();
                }
                if(checkedId == R.id.boy_rb)
                {
                    gender = "boy";
                }
                else if(checkedId == R.id.girl_rb)
                {
                    gender = "girl";
                }

            }
        });
    }



    private float calBmi(float height_float, float weight_float) {
        float bmi=0;
        float h_m = height_float/100;
        bmi=weight_float/(h_m*h_m);

        return bmi;
    }
}