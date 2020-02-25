package org.itcube.widgetexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioButtonLondon = (RadioButton) findViewById(R.id.radioButtonLondon);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final CheckBox checkBoxTransparency = (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox checkBoxTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox checkBoxResize = (CheckBox) findViewById(R.id.checkBoxReSize);
        final TextClock textClock = (TextClock) findViewById(R.id.textClock);
        final Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Switch switch1 = (Switch) findViewById(R.id.switch1);

        checkBoxTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setAlpha(.1f);
                } else {
                    imageView.setAlpha(1f);
                }
            }
        });

        checkBoxTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                } else {
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });

        checkBoxResize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonLondon:
                        textClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        textClock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:
                        textClock.setTimeZone("America/New_York");
                        break;
                    case R.id.radioButtonEuropeanEmpire:
                        textClock.setTimeZone("Europe/Brussels");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText());
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
