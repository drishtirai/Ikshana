package com.example.ikshana6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView carddash1, carddash2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carddash1=(CardView) findViewById(R.id.eyetest);
        carddash2=(CardView) findViewById(R.id.exercise);
        carddash1.setOnClickListener(this);
        carddash2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.eyetest:
                i = new Intent(this, Eyetestdash.class);
                startActivity(i);
                break;
            case R.id.exercise:
                i = new Intent(this, eyeexercise.class);
                startActivity(i);
                break;

        }

    }
}