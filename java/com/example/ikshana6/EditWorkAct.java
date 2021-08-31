package com.example.ikshana6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class EditWorkAct extends AppCompatActivity {

    TextView titlepage, subtitlepage, btnexercise, fitonetitle, fitonedesc,
            fittwotitle, fittwodesc, workvalue;

    Button btnlocked, btnadd, btnremove;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo;

    Animation bttone, bttwo, bttfour, bttfive;

    int sumworkout = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_work);

        //load animation
        bttone = AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this,R.anim.bttwo);
        bttfour = AnimationUtils.loadAnimation(this,R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this,R.anim.bttfive);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        fitone = findViewById(R.id.fitone);
        fittwo = findViewById(R.id.fittwo);

        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);

        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
        fittwotitle = findViewById(R.id.fittwotitle);
        fittwodesc = findViewById(R.id.fittwodesc);

        btnlocked = findViewById(R.id.btnlocked);
        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);

        workvalue = findViewById(R.id.workvalue);

        btnexercise = findViewById(R.id.btnexercise);

        //import font
        //Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        //Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        //Typeface Vidaloka = Typeface.createFromAsset(getAssets(),"fonts/Vidaloka.ttf");

        //customize font
        //titlepage.setTypeface(Vidaloka);
        //subtitlepage.setTypeface(Mlight);
        //btnexercise.setTypeface(MMedium);

        //fitonedesc.setTypeface(MLight);
        //fitonetitle.setTypeface(MMedium);
        //fittwodesc.setTypeface(MLight);
        //fittwotitle.setTypeface(MMedium);

        //workvalue.setTypeface(MMedium);
        //btnlocked.setTypeface(MMedium);
        //btnadd.setTypeface(MMedium);

        btnadd.setOnClickListener((v) -> {
            sumworkout +=1;
            workvalue.setText(sumworkout+"");
        });

        btnremove.setOnClickListener((v) -> {
            if(sumworkout <=0){
                Toast.makeText(getApplicationContext(),"SORRY!",Toast.LENGTH_SHORT).show();
            }
            else{
                sumworkout -= 1;
                workvalue.setText(sumworkout+"");
            }
        });

        //give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(EditWorkAct.this, ShowWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);

        btnexercise.startAnimation(bttfive);
        bgprogress.startAnimation(bttfive);

    }
}