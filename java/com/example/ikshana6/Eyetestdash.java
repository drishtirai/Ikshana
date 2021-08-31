package com.example.ikshana6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import static com.example.ikshana6.R.layout.activity_eyetestdash;

public class Eyetestdash extends AppCompatActivity implements View.OnClickListener{

    private CardView card1, card2, card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_eyetestdash);
        card1=(CardView) findViewById(R.id.Tab1);
        card2=(CardView) findViewById(R.id.Tab2);
        card3=(CardView) findViewById(R.id.Tab3);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.Tab1:
                i = new Intent(this,Visualacuity.class);
                startActivity(i);
                break;
            case R.id.Tab2:
                i = new Intent(this,Colorblindness.class);
                startActivity(i);
                break;
            case R.id.Tab3:
                i = new Intent(this,AMD.class);
                startActivity(i);
                break;


        }

    }
}