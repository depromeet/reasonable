package com.reasonable.univfestival.api;

import com.reasonable.univfestival.model.Festival;
import com.reasonable.univfestival.model.University;

import java.util.List;

import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jkimab on 2017. 4. 26..
 */

public class MockUnivFestivalAPI implements UnivFestivalAPI {
    @Override
    public Observable<List<Festival>> listFestival(@Path("page") int pageCount) {
        return Observable.just(mockFestivalList());
    }

    @Override
    public Observable<List<University>> getUniversityList() {
        return Observable.just(mockUniversityList());
    }

    private List<University> mockUniversityList() {
        return null;
    }

    private List<Festival> mockFestivalList() {
        return null;
    }
}
