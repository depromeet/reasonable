package com.reasonable.univfestival.api;

import com.reasonable.univfestival.model.Festival;
import com.reasonable.univfestival.model.University;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public interface UnivFestivalAPI {
    @GET("festival/list/{page}")
    Observable<List<Festival>> listFestival(@Path("page") int pageCount);

    @GET("university/")
    Observable<List<University>> getUniversityList();




}
