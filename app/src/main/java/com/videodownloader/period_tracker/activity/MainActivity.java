package com.videodownloader.period_tracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.videodownloader.period_tracker.R;
import com.videodownloader.period_tracker.databinding.ActivityInformationBinding;
import com.videodownloader.period_tracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intListener();
    }

    private void intListener() {
        binding.tvStarted.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_started:
                startActivity(new Intent(MainActivity.this,InformationActivity.class));
        }

    }
}