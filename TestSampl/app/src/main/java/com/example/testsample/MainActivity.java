package com.example.testsample;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText text;
    private TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.inputValue);
        result = findViewById(R.id.tv_result);
    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RadioButton celsiusButton = findViewById(R.id.radio0);
                RadioButton fahrenheitButton = findViewById(R.id.radio1);
                PropertyValuesHolder scaleAnimationX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.1f, 1f);
                PropertyValuesHolder scaleAnimationY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.1f, 1f);
                ObjectAnimator scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(text, scaleAnimationX, scaleAnimationY);
                scaleAnimation.setDuration(500);
                scaleAnimation.start();

                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    result.setText(String
                            .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    result.setText(String
                            .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;
        }
    }

}