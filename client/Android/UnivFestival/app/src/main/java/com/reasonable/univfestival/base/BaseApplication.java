package com.reasonable.univfestival.base;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;
import com.orm.SugarContext;
import com.reasonable.univfestival.BuildConfig;
import com.reasonable.univfestival.R;
import com.reasonable.univfestival.api.UnivFestivalAPI;
import com.reasonable.univfestival.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class BaseApplication extends Application {
    private static UnivFestivalAPI festivalAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());

        SugarContext.init(this);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            clientBuilder.addInterceptor(logging)
                    .addNetworkInterceptor(new StethoInterceptor());
        }

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()))
                .baseUrl(Constants.BASE_URL)
                .client(clientBuilder.build())
                .build();

        festivalAPI = retrofit.create(UnivFestivalAPI.class);
    }

    public static UnivFestivalAPI getFestivalAPI() {
        return festivalAPI;
    }
}
