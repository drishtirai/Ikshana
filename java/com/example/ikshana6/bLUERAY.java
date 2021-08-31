package com.example.ikshana6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SharedMemory;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class bLUERAY extends AppCompatActivity {
    private SharedMemory mSharedMemory;
    private ToggleButton mToggleButton;
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar alpha, red, green, blue;
        alpha = findViewById(R.id.seek_alpha);
        red = findViewById(R.id.seek_red);
        green = findViewById(R.id.seek_green);
        blue = findViewById(R.id.seek_blue);

        mToggleButton = findViewById(R.id.startButton);

        mSharedMemory = new SharedMemory(this);

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSharedMemory.setAlpha(alpha.getProgress());
                mSharedMemory.setRed(red.getProgress());
                mSharedMemory.setGreen(green.getProgress());
                mSharedMemory.setBlue(blue.getProgress());

                if (ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE) {
                    Intent i = new Intent(bLUERAY.this, ScreenFilterService.class);
                    startService(i);
                }

                mToggleButton.setChecked(ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        alpha.setOnSeekBarChangeListener(changeListener);
        red.setOnSeekBarChangeListener(changeListener);
        green.setOnSeekBarChangeListener(changeListener);
        blue.setOnSeekBarChangeListener(changeListener);

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(bLUERAY.this, ScreenFilterService.class);
                if (ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE) {
                    stopService(i);
                }
                else {
                    startService(i);
                }

                refresh();
            }
        });
    }

    private void refresh() {
        if (mCountDownTimer != null)
            mCountDownTimer.cancel();

        mCountDownTimer = new CountDownTimer(100,100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mToggleButton.setChecked(ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE);

            }
        };

        mCountDownTimer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mToggleButton.setChecked(ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE);
    }
}