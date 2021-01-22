package com.aditya.sinewave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtText;
    ToggleButton toggleButton;
    TextView txtView;
    public PlayWave wave= new PlayWave();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText= findViewById(R.id.edtFrequency);
        toggleButton= findViewById(R.id.tbOnOff);
        txtView= findViewById(R.id.txt);
        toggleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int frequency = Integer.parseInt(edtText.getText().toString());
        wave.SetWave(frequency);
        boolean on = toggleButton.isChecked();
        if(on){
            wave.StartWave();
        }
        else {
            wave.StopWave();
        }

    }
}