package com.reasonable.univfestival.base;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public interface Presenter<V> {
    void attach(V view);
    void detach();
}
