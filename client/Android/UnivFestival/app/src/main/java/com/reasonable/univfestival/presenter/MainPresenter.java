package com.reasonable.univfestival.presenter;

import com.reasonable.univfestival.base.BaseView;
import com.reasonable.univfestival.base.Presenter;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class MainPresenter implements Presenter {


    public interface View extends BaseView {
        void render();

    }

    private CompositeSubscription subscriptions;

    public MainPresenter() {
        this.subscriptions = new CompositeSubscription();
    }

    @Override
    public void attach(BaseView view) {
        if (subscriptions.isUnsubscribed()) {
            subscriptions = new CompositeSubscription();
        }

        subscriptions.add(getInitialSubscription(view));
    }

    public Subscription getInitialSubscription(BaseView view) {
        return Observable
                .just("")
                .subscribe(onNext -> {

                }, onError -> {

                });
    }

    @Override
    public void detach() {

    }
}
