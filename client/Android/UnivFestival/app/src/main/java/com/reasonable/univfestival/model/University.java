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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }
}
