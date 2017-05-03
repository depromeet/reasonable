package com.reasonable.univfestival;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hugo.weaving.DebugLog;

/**
 * Created by jkimab on 2017. 5. 3..
 */

public class FestivalDetailActivity extends AppCompatActivity {
    public static final String UNIVERSITY_ID_KEY = "university_id";
    private long universityKey;

    @Override
    @DebugLog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_detail);
        Intent intent = getIntent();
        if (intent != null) {
            universityKey = intent.getLongExtra(UNIVERSITY_ID_KEY, -1);
        }
    }

    @Override
    @DebugLog
    protected void onStart() {
        super.onStart();
    }

    @Override
    @DebugLog
    protected void onStop() {
        super.onStop();
    }
}
