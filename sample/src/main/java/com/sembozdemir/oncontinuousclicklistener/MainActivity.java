package com.sembozdemir.oncontinuousclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sembozdemir.oncontinuousclicklistener.library.OnContinuousClickListener;

public class MainActivity extends AppCompatActivity {
    private int delay = 500;
    private int count = 0;
    private SeekBar seekBarDelay;
    private TextView textViewCount;
    private Button buttonInc;
    private Button buttonDec;
    private TextView textViewDelayLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setButtons();

        seekBarDelay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                delay = progress + 100;
                setTextViewDelay();
                setButtons();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setTextViewDelay() {
        String label = "Delay: " + delay;
        textViewDelayLabel.setText(label);
    }

    private void init() {
        textViewCount = (TextView) findViewById(R.id.textViewCount);
        textViewCount.setText(String.valueOf(count));
        textViewDelayLabel = (TextView) findViewById(R.id.textViewDelay);
        setTextViewDelay();
        buttonInc = (Button) findViewById(R.id.buttonInc);
        buttonDec = (Button) findViewById(R.id.buttonDec);
        seekBarDelay = (SeekBar) findViewById(R.id.seekBarDelay);
        seekBarDelay.setProgress(delay);
    }

    private void setButtons() {
        buttonInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc();
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec();
            }
        });

        buttonInc.setOnLongClickListener(new OnContinuousClickListener(delay) {
            @Override
            public void onContinuousClick(View v) {
                inc();
            }
        });

        buttonDec.setOnLongClickListener(new OnContinuousClickListener(delay) {
            @Override
            public void onContinuousClick(View v) {
                dec();
            }
        });
    }

    private void dec() {
        count--;
        textViewCount.setText(String.valueOf(count));
    }

    private void inc() {
        count++;
        textViewCount.setText(String.valueOf(count));
    }
}
