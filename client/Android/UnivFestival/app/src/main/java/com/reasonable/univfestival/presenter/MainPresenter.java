package com.reasonable.univfestival.presenter;

import com.orm.SugarRecord;
import com.reasonable.univfestival.api.UnivFestivalAPI;
import com.reasonable.univfestival.base.AdapterInterface;
import com.reasonable.univfestival.base.BaseView;
import com.reasonable.univfestival.base.Presenter;
import com.reasonable.univfestival.model.Festival;
import com.reasonable.univfestival.model.University;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
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

        subscriptions.add(getUnversityListSubscription()
                        .concatWith(getFestivalListSubscription())
                        .subscribeOn(Schedulers.io())
                        .subscribe(onNext -> {
                            // Do nothing
                        }, view::handleError));
    }

    private Observable<Boolean> getFestivalListSubscription() {
        return Observable.range(1, Integer.MAX_VALUE - 1)
                .concatMap(integer -> api
                        .getListFestival(integer)
                        .observeOn(AndroidSchedulers.mainThread())
                        .observeOn(Schedulers.io())
                        .doOnNext(list -> {
                            for (Festival festival : list) {
                                SugarRecord.save(festival);
                            }
                        })
                        .doOnNext(list -> adapter.addAll(list))
                        .map(result -> integer < result.get(0).getMax_pages()))
                .takeWhile(shouldContinue -> shouldContinue);
    }

    public Observable<Boolean> getUnversityListSubscription() {
        return Observable.range(1, Integer.MAX_VALUE - 1)
                .concatMap(integer -> api
                        .getUniversityList(integer)
                        .doOnNext(list -> {
                            for (University university : list) {
                                SugarRecord.save(university);
                            }
                        })
                        .map(result -> integer < result.get(0).getMax_pages())
                )
                .takeWhile(shouldContinue -> shouldContinue);
    }


    @Override
    public void detach() {
        subscriptions.unsubscribe();
    }
}
