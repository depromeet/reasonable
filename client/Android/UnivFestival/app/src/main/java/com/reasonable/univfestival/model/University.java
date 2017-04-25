package com.reasonable.univfestival.model;

import com.orm.SugarRecord;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class University extends SugarRecord {
    /**
     *
     University
     - id
     - name
     - extra
     - img_link
     */

    long id;
    String name;
    String extra;
    String img_link;

    public University() {
    }

    public University(long id, String name, String extra, String img_link) {
        this.id = id;
        this.name = name;
        this.extra = extra;
        this.img_link = img_link;
    }
}
