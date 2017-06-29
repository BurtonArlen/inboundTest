package com.burton.arlen.inboundbrainteaser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.goButton)Button goButton;
    public int[] a = new int[]{4,5,6};
    private Map<Integer, Integer> map = new HashMap<>(a.length);
    private boolean condition;
    private boolean conditionShort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        goButton.setOnClickListener(this);
        createMap();
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

    private void createMap() {
        for (Integer mapping : a)
        {
            map.put(mapping, mapping);
            Log.d("mapContents", String.valueOf(map));
        }
        Log.d("mapContents", String.valueOf(map));
    }

    private void solveShort(){
        for(int v = 0; v < map.size(); v++){
            int int1;
            int int2;
            int1 = map.get(a[v]);
            int2 = (int1 - 10)*-1;
            if (map.containsValue(int2)){
                Log.d("value of sum", "is equal to 10");
                Log.d("return int1", String.valueOf(int1));
                Log.d("return int2", String.valueOf(int2));
                Log.d("return sum", String.valueOf(int1 + int2));
            } else {
                Log.d("value of sum", "is NOT equal to 10");
                Log.d("return int1", String.valueOf(int1));
                Log.d("return int2", String.valueOf(int2));
                Log.d("return sum", String.valueOf(int1 + int2));
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
