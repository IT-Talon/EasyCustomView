package com.talon.easycustomview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ThemeCustomView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (ThemeCustomView) findViewById(R.id.theme_view);
        mView.setColors(new int[]{Color.GRAY, Color.BLUE, Color.GREEN, Color.YELLOW});
        Log.i("Talon", "" + mView.getColors()[0]);
    }
}
