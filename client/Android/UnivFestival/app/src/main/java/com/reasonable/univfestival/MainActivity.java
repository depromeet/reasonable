package com.reasonable.univfestival;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.reasonable.univfestival.api.UnivFestivalAPI;
import com.reasonable.univfestival.base.BaseApplication;
import com.reasonable.univfestival.base.FestivalAdapter;
import com.reasonable.univfestival.presenter.MainPresenter;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private static final String TAG = "MainActivity";
    private FestivalAdapter adapter;
    private UnivFestivalAPI api;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MainPresenter presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        setActionBarInitSettings(getSupportActionBar());


        api = BaseApplication.getFestivalAPI();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_frame);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new FestivalAdapter(new ArrayList<>(), this);
        adapter.setParallaxHeader(getLayoutInflater().inflate(R.layout.parallax_header, recyclerView, false), recyclerView);
        adapter.setOnParallaxScroll((percentage, offset, parallax) -> {
            Drawable c = toolbar.getBackground();
            c.setAlpha(Math.round(percentage * 255));
            toolbar.setBackground(c);
        });
        recyclerView.setAdapter(adapter);

        presenter = new MainPresenter(api, adapter);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void render() {

    }

    @Override
    public void handleError(Exception e) {

    }

    public void setActionBarInitSettings(ActionBar actionBar) {
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }
}
