package com.burton.arlen.inboundbrainteaser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.goButton)Button goButton;
    public int[] a = new int[]{4,5,6};
    private boolean condition;
    private boolean conditionShort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        goButton.setOnClickListener(this);
    }

    private void solveBrainTeaserLong(){
        for(int i = 0; i < a.length; i++){
            for (int x = 0; x < a.length; x++){
//                Log.d("return a[i]", String.valueOf(a[i]));
//                Log.d("return a[x]", String.valueOf(a[x]));
//                Log.d("return total", String.valueOf(a[i]+a[x]));
                if (a[i] + a[x] == 10){
                    condition = true;
//                    Log.d("condition met", String.valueOf(condition));
                } else {
                    condition = false;
//                    Log.d("condition met", String.valueOf(condition));
                }
            }
        }
    }

    private void solveShort(){
        Log.d("Short", "started");
        int g = 0;
        for (int w = 0; w < a.length; w++){
                int b = a.length - 1;
                int f = b - g;
            if (a[w] + a[f] != 10){
                g = g + 1;
                conditionShort = false;
                Log.d("return a[w]", String.valueOf(a[w]));
                Log.d("return a[f]", String.valueOf(a[f]));
                Log.d("return total", String.valueOf(a[w]+a[f]));
                Log.d("condition met", String.valueOf(conditionShort));
            } else {
                if (w < 0){
                    w--;
                } else {
                    w = 0;
                }
                conditionShort = true;
                Log.d("return a[w]", String.valueOf(a[w]));
                Log.d("return a[f]", String.valueOf(a[f]));
                Log.d("return total", String.valueOf(a[w]+a[f]));
                Log.d("condition met", String.valueOf(conditionShort));
            }
        }
    }

    @Override
    public void onClick(View v){
        if (v == goButton){
            solveBrainTeaserLong();
            solveShort();
        }
    }
}
