package com.videodownloader.period_tracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.videodownloader.period_tracker.databinding.ActivityLastPeriodStartBinding;

public class Last_Period_StartActivity extends AppCompatActivity {
        ActivityLastPeriodStartBinding binding;

    private final PeriodRecalculateReceiver recalculateReceiver = new PeriodRecalculateReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLastPeriodStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}