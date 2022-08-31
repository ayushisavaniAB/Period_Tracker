package com.videodownloader.period_tracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.videodownloader.period_tracker.R;
import com.videodownloader.period_tracker.databinding.ActivityInformationBinding;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         initListener();
    }

    private void initListener() {
        binding.confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                startActivity(new Intent(InformationActivity.this,CycleCalaulationaActivity.class));
        }
    }
}