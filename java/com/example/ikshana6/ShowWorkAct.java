package com.example.ikshana6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ShowWorkAct extends AppCompatActivity {
    Button btnnewwork, btnpopwork;
    TextView titlepage, subtitlepage;
    Animation exittr, exitfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work);

        exittr = AnimationUtils.loadAnimation(this, R.anim.exittr);
        exitfr = AnimationUtils.loadAnimation(this, R.anim.exitfr);

        btnnewwork = findViewById(R.id.btnnewwork);
        btnpopwork = findViewById(R.id.btnpopwork);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        //import font
        //Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        //Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        //Typeface Vidaloka = Typeface.createFromAsset(getAssets(),"fonts/Vidaloka.ttf");

        //customize font
        //titlepage.setTypeface(Vidaloka);
        //subtitlepage.setTypeface(Mlight);
        //btnnewwork.setTypeface(MMedium);
        //btnpopwork.setTypeface(MMedium);

        btnnewwork.setSelected(true);

        btnnewwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btnnewwork.setSelected(true);
                btnnewwork.setTextColor(Color.parseColor("#356c64"));

                btnpopwork.setTextColor(Color.parseColor("#25293E"));
                btnpopwork.setSelected(false);

                Fragment fragment;
                fragment = new NewWorkFrag();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction txn = manager.beginTransaction();

                txn.setCustomAnimations(R.anim.exitfr, R.anim.exittr, R.anim.exitfr, R.anim.exittr);
                txn.addToBackStack(null);

                txn.replace(R.id.contentwrap, fragment);
                txn.commit();
            }
        });
        
        btnpopwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btnpopwork.setSelected(true);
                btnpopwork.setTextColor(Color.parseColor("#356c64"));

                btnnewwork.setTextColor(Color.parseColor("#25293E"));
                btnnewwork.setSelected(false);

                Fragment fragment;
                fragment = new PopWorkFrag();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction txn = manager.beginTransaction();

                txn.setCustomAnimations(R.anim.exitfr, R.anim.exittr, R.anim.exitfr, R.anim.exittr);
                txn.addToBackStack(null);

                txn.add(R.id.contentwrap, fragment);
                txn.commit();
            }
        });
    }
}