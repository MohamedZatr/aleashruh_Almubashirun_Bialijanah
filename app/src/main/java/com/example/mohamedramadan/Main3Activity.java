package com.example.mohamedramadan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
   //seekbar to set the value of text size
    SeekBar seekBar;
    // use this value to help the user to select good size to read
    TextView textView;
    // Save the size of TextView
    float Size;
    // Defulte Value size of TextView
    final float defulteSize= 20.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // get the seekBar from xml
        seekBar = findViewById(R.id.seek);
        // set The Max Value Of seekbar
        seekBar.setMax(45);
        // get the TextView from xml
        textView = findViewById(R.id.txsize);
        //get the size of textView from
        Size = DataSaved.getDataSaved(this);
        // use this to set the size of textView if the user open the app
        if (Size >= defulteSize) {
            seekBar.setProgress((int) Size);
            textView.setTextSize((int) Size);
        }

        else {
            seekBar.setProgress((int) defulteSize);
            textView.setTextSize(defulteSize);
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                DataSaved.saveSize(Main3Activity.this,i);

                if (i >= 20) {
                    textView.setTextSize((float) i);
                    FragmentOfContent.changetextSize((float) i);
                }
                else
                {
                    textView.setTextSize(defulteSize);
                    FragmentOfContent.changetextSize(defulteSize);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
