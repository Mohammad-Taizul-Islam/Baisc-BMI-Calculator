package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextWeight,editTextHeightFt,editTextHeightIn;
    private Button buttonCalculator;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWeight=findViewById(R.id.etWeight);
        editTextHeightFt=findViewById(R.id.etHeightFt);
        editTextHeightIn=findViewById(R.id.etHeightIn);
        buttonCalculator=findViewById(R.id.buttonMBI);
        textViewResult=findViewById(R.id.textResult);

        buttonCalculator.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        double height,result;
        String feet,inc,weight;
        feet=editTextHeightFt.getText().toString();
        inc=editTextHeightIn.getText().toString();
        weight=editTextWeight.getText().toString();

        height= Double.parseDouble(feet)*0.3048 + Double.parseDouble(inc)*0.0254;
        Log.d("height", String.valueOf(height));

        result=Double.parseDouble(weight)/Math.pow(height,2.0);
        //textViewResult.setText("Your BMI is"+result);

        if (result <18.5){
            textViewResult.setText("Your BMI is"+result);
            textViewResult.setTextColor(getColor(R.color.grayGreen));
            textViewResult.setText("You are Underweight");
        } else if (result >= 18.5 && result <24.9) {
            textViewResult.setText("Your BMI is"+result);
            textViewResult.setTextColor(getColor(R.color.green));
            textViewResult.setText("You are Normal");

        } else if (result >=25 && result< 29.9) {
            textViewResult.setText("Your BMI is"+result);
            textViewResult.setTextColor(getColor(R.color.grayRed));
            textViewResult.setText("You are Overweight");
        } else if (result >30) {
            textViewResult.setText("Your BMI is"+result);
            textViewResult.setTextColor(getColor(R.color.red));
            textViewResult.setText("You are Obese");
        }

    }
}