package com.example.project10_3_self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("세컨드 액티비티");

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("Calc"));

        int cal_value = 0;
        if(calc.equals("+")){
            cal_value = inIntent.getIntExtra("Num1", 0) +
                    inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("-")){
            cal_value = inIntent.getIntExtra("Num1", 0) -
                    inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("*")){
            cal_value = inIntent.getIntExtra("Num1", 0) *
                    inIntent.getIntExtra("Num2", 0);
        }
        else{
            cal_value = inIntent.getIntExtra("Num1", 0) /
                    inIntent.getIntExtra("Num2", 0);
        }

        final int ret_value = cal_value;

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", ret_value);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}