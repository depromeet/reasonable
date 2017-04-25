package com.reasonable.univfestival.model;

import com.orm.SugarRecord;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class Artist extends SugarRecord {
    /**
     * Artist
     - id
     - name
     - naver_link
     */

    long id;
    String name;
    String naver_link;

    public Artist() {
    }

    public Artist(long id, String name, String naver_link) {
        this.id = id;
        this.name = name;
        this.naver_link = naver_link;
    }
}

