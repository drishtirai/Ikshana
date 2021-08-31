package com.example.ikshana6;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Paperonboarding extends AppCompatActivity {

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paperonboarding);

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();

    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {

        PaperOnboardingPage scr1 = new PaperOnboardingPage("Get Regular Exercise", "Exercise may help to prevent diabetes, and high cholesterol. These diseases can lead to some eye or vision problems.",
                Color.parseColor("#ffffff"), R.drawable.exercise, R.drawable.dot);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Balanced Diet", "Your diet should include plenty or fruits and vegetables, especially deep yellow and green leafy vegetables.",
                Color.parseColor("#ffffff"), R.drawable.diet, R.drawable.dot);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Give Your Eyes Rest", "To reduce eyestrain, try the 20-20-20 rule: Every 20 minutes, look away about 20 feet in front of you for 20 seconds.",
                Color.parseColor("#ffffff"), R.drawable.eye, R.drawable.dot);
        PaperOnboardingPage scr4 = new PaperOnboardingPage("Eye Infections", "Wash your hands well before you put in or take out your contact lenses.",
                Color.parseColor("#ffffff"), R.drawable.hand, R.drawable.dot);
        PaperOnboardingPage scr5 = new PaperOnboardingPage("Wear Sunglasses", "Protect your eyes by using sunglasses that block out 99 to 100% of both UV-A and UV-B radiation.",
                Color.parseColor("#ffffff"), R.drawable.glasses, R.drawable.dot);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        elements.add(scr5);
        return elements;

    }
}