package com.videodownloader.period_tracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.videodownloader.period_tracker.R;
import com.videodownloader.period_tracker.databinding.ActivityCycleCalaulationaBinding;
import com.videodownloader.period_tracker.period_days.PeriodDaysManager;
import com.videodownloader.period_tracker.predictor.PeriodCalculator;
import com.videodownloader.period_tracker.utils.AppPreferences;
import com.videodownloader.period_tracker.utils.OptionalUtil;

public class CycleCalaulationaActivity extends AppCompatActivity implements View.OnClickListener{
ActivityCycleCalaulationaBinding binding;
View view;

    private final PeriodRecalculateReceiver recalculateReceiver = new PeriodRecalculateReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCycleCalaulationaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    initListner();
    }

    private void initListner() {
        binding.ivMinusone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menstruationLengthMinusOne(view);
            }
        });
        binding.ivPlussone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                periodLengthPlusOne(view);
            }
        });
        binding.tvStarted.setOnClickListener(this);
    }

    private void periodLengthPlusOne(View view) {
        changeNumericalFieldValueByDiff(R.id.period_length_value, 1);
    }

    private void menstruationLengthMinusOne(View view) {
        changeNumericalFieldValueByDiff(R.id.period_length_value, -1);
    }

    @SuppressLint("NewApi")
    private void changeNumericalFieldValueByDiff(int fieldId, int diff) {
        TextView textView = (TextView) findViewById(fieldId);
        Optional<Integer> optionalFieldValue = OptionalUtil.parseInteger(textView.getText().toString());
        if (optionalFieldValue.isPresent()) {
            textView.setText(String.valueOf(optionalFieldValue.get() + diff));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_started:
//                startActivity(new Intent(CycleCalaulationaActivity.this,Period_lengthActivity.class));

                updateData(view);
        }
    }

    private void updateData(View view) {
        SharedPreferences preferences = getSharedPreferences(AppPreferences.SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        boolean userPreferencesAvailable = preferences
                .getBoolean(AppPreferences.BASIC_USER_PREFERENCES_AVAILABLE, false);
        SharedPreferences.Editor editor = preferences.edit();
        savePreferenceStringValue(R.id.period_length_value, AppPreferences.PERIOD_LENGTH_KEY, editor);
        editor.putBoolean(AppPreferences.BASIC_USER_PREFERENCES_AVAILABLE, true);
        editor.apply();

        if (!userPreferencesAvailable) {
            recalculateReceiver.setPredictionService(this);
        }

        startActivity(new Intent(CycleCalaulationaActivity.this,Period_lengthActivity.class));
    }
    public void savePreferenceStringValue(int viewId, String preferenceKey, SharedPreferences.Editor editor) {
        TextView view = (TextView) findViewById(viewId);
        editor.putString(preferenceKey, view.getText().toString());
    }

}