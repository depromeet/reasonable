package com.reasonable.univfestival.base;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public interface Presenter {
    void attach(BaseView view);
    void detach();
}
