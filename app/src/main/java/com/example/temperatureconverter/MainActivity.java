package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText Input, answer;
    ToggleButton temp;
    Button convertT;
    double Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input = findViewById(R.id.input);
        temp = findViewById(R.id.Temp_switch);
        answer = findViewById(R.id.Answer);
        convertT = findViewById(R.id.convert);

        temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String inp = Input.getText().toString();
                double inp_temp = Double.parseDouble(inp);

                if (isChecked){
                    Answer = (inp_temp-32)*5/9;
                }else {
                    Answer = (inp_temp*9/5)+32;
                }

            }
        });

        convertT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                answer.setText(" " + numberFormat.format(Answer));
            }
        });

    }


}