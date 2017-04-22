package com.reasonable.univfestival;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.reasonable.univfestival.api.UnivFestivalAPI;
import com.reasonable.univfestival.base.BaseApplication;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UnivFestivalAPI api = BaseApplication.getFestivalAPI();
    }
}
