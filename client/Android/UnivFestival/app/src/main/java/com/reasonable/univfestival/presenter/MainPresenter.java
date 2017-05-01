package com.reasonable.univfestival.presenter;

import android.util.Log;

import com.orm.SugarRecord;
import com.reasonable.univfestival.api.UnivFestivalAPI;
import com.reasonable.univfestival.base.AdapterInterface;
import com.reasonable.univfestival.base.BaseView;
import com.reasonable.univfestival.base.Presenter;
import com.reasonable.univfestival.model.Festival;
import com.reasonable.univfestival.model.University;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class MainPresenter implements Presenter<MainPresenter.View> {
    private static final String TAG = "MainPresenter";
    public interface View extends BaseView {
        void render();

    }

    private CompositeSubscription subscriptions;
    private AdapterInterface<Festival> adapter;
    private UnivFestivalAPI api;

    public MainPresenter(UnivFestivalAPI api, AdapterInterface adapter) {
        this.subscriptions = new CompositeSubscription();
        this.api = api;
        this.adapter = adapter;
    }

    @Override
    public void attach(View view) {
        if (subscriptions.isUnsubscribed()) {
            subscriptions = new CompositeSubscription();
        }

        subscriptions.add(getUnversityListSubscription());
        subscriptions.add(getFestivalListSubscription(view));
    }

    private Subscription getFestivalListSubscription(View view) {
        return Observable.range(1, Integer.MAX_VALUE - 1)
                .concatMap(integer -> api
                        .getListFestival(integer)
                        .doOnNext(list -> adapter.addAll(list))
                        .doOnNext(list -> {
                            for (Festival festival : list) {
                                Log.d(TAG, "Festival: " + festival.getName());
                                SugarRecord.save(festival);
                            }
                        })
                        .map(result -> integer < result.get(0).getMax_pages()))
                .takeWhile(shouldContinue -> shouldContinue)
                .subscribeOn(Schedulers.io())
                .subscribe(onNext -> {

                }, onError -> {
                    Log.e(TAG, "Error while fetching University List", onError);
                });
    }

    public Subscription getUnversityListSubscription() {
        return Observable.range(1, Integer.MAX_VALUE - 1)
                .concatMap(integer -> api
                        .getUniversityList(integer)
                        .doOnNext(list -> {
                            for (University university : list) {
                                Log.d(TAG, "University: " + university.getName());
                                SugarRecord.save(university);
                            }
                        })
                        .map(result -> integer < result.get(0).getMax_pages())
                )
                .takeWhile(shouldContinue -> shouldContinue)
                .subscribeOn(Schedulers.io())
                .subscribe(onNext -> {

                }, onError -> {
                    Log.e(TAG, "Error while fetching University List", onError);
                });

    }


    @Override
    public void detach() {
        subscriptions.unsubscribe();
    }
}
