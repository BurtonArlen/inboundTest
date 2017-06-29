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
    public int[] a = new int[]{4,6,2,22,8,9,79,5,7,1,3,14};
    private Map<Integer, Integer> map = new HashMap<>(a.length);
    private boolean conditionSmallData;
    private boolean condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        goButton.setOnClickListener(this);
        createMap();
    }

    private void solutionBigData(){
        for(int i = 0; i < a.length; i++){
            for (int x = 0; x < a.length; x++){
                if (a[i] + a[x] == 10){
                    condition = true;
                } else {
                    condition = false;
                }
            }
        }
    }

    private void createMap() {
        for (Integer mapping : a){
            map.put(mapping, mapping);
        }
    }

    private void solutionSmallData(){
        for(int v = 0; v < map.size(); v++){
            int int1 = map.get(a[v]);
            int int2 = (int1 - 10)*-1;
            if (map.containsValue(int2)){
                if (int1 + map.get(int2) == 10){
                    Log.d("value of sum", "is equal to 10");
                    Log.d("return int1", String.valueOf(int1));
                    Log.d("return int2", String.valueOf(int2));
                    Log.d("return sum", String.valueOf(int1 + int2));
                    conditionSmallData = true;
                }
            } else {
                Log.d("value of sum", "is NOT equal to 10");
                Log.d("return int1", String.valueOf(int1));
                Log.d("return int2", String.valueOf(int2));
                Log.d("return sum", String.valueOf(int1 + int2));
                conditionSmallData = false;
            }
        }
    }

    @Override
    public void onClick(View v){
        if (v == goButton){
            solutionBigData();
            solutionSmallData();
        }
    }
}

