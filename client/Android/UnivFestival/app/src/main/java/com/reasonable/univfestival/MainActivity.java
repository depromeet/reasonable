package com.reasonable.univfestival;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.reasonable.univfestival.base.UniversityAdapter;
import com.reasonable.univfestival.model.University;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private UniversityAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_frame);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //adapter = new UniversityAdapter(new ArrayList<University>(), this);
        adapter = new UniversityAdapter(getDummyData(), this);
        adapter.setParallaxHeader(getLayoutInflater().inflate(R.layout.parallax_header, recyclerView, false), recyclerView);
        adapter.setOnParallaxScroll((percentage, offset, parallax) -> {
            Drawable c = toolbar.getBackground();
            c.setAlpha(Math.round(percentage * 255));
            toolbar.setBackground(c);
        });
        recyclerView.setAdapter(adapter);
    }

    private List getDummyData() {
        List list = new ArrayList<University>();
        for (int i = 0; i < 20; i++) {
            University newUniversity = new University();
            newUniversity.setId((long) i);
            newUniversity.setName("가천대학교" + i);
            newUniversity.setImg_link("www.naver.com");
            newUniversity.setExtra("05월 08일 ~ 11일");
            list.add(newUniversity);
        }
        return list;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
