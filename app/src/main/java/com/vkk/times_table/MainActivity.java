package com.vkk.times_table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    ListView TimesTableListView;

    public void generatetimesTable(int timestable)
    {
        ArrayList<String> timestablecontent=new ArrayList<String>();

        for(int i=1;i<=10;i++)
        {
            timestablecontent.add(Integer.toString(i*timestable));
        }
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timestablecontent);
        TimesTableListView.setAdapter(arrayadapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar TimesTableSeekBar=(SeekBar)findViewById(R.id.TimesTableSeekBar);
         TimesTableListView=(ListView)findViewById(R.id.TimesTableListView);
        TimesTableSeekBar.setMax(1000);
        TimesTableSeekBar.setProgress(1);
        TimesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;
                if(progress<1)
                {
                    timesTable=min;
                    TimesTableSeekBar.setProgress(min);
                }else
                {
                    timesTable=progress;
                }
                  generatetimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generatetimesTable(13);

    }
}
