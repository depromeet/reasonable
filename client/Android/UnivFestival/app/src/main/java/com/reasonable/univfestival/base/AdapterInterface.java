package com.reasonable.univfestival.base;

import java.util.List;

/**
 * Created by jkimab on 2017. 5. 1..
 */

public interface AdapterInterface<T> {
    void addAll(List<T> list);
    void add(T object);
    void removeAll();
}
