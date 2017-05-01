package com.reasonable.univfestival.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

/**
 * Created by jkimab on 2017. 4. 22..
 */

@Table
public class University {
    private transient Long id;

    @SerializedName( "id" )
    @Expose
    long externalId;

    @Expose
    String name;

    @Expose
    String naver_link;

    @Expose
    String image_link;

    @Expose
    long max_pages;

    public University() {
    }

    public University(Long id, long externalId, String name, String naver_link, String image_link, long max_pages) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.naver_link = naver_link;
        this.image_link = image_link;
        this.max_pages = max_pages;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNaver_link() {
        return naver_link;
    }

    public void setNaver_link(String naver_link) {
        this.naver_link = naver_link;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public long getMax_pages() {
        return max_pages;
    }

    public void setMax_pages(long max_pages) {
        this.max_pages = max_pages;
    }
}
