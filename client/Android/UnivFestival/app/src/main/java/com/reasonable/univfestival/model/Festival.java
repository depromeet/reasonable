package com.reasonable.univfestival.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by jkimab on 2017. 4. 22..
 */

@Table
public class Festival {
    /**
     "id": 17,
     "max_pages": 1,
     "university_name": "가톨릭대학교",
     "name": "2016 가톨릭대학교 축제",
     "start_date": "2016-05-08T15:00:00",
     "end_date": "2016-05-11T15:00:00",
     "poster_link": "#",
     "university": 2
     */
    private transient Long id;

    @SerializedName( "id" )
    @Unique
    @Expose
    long externalId;

    @Expose
    long max_pages;

    @Expose
    String university_name;

    @Expose
    String name;

    @Expose
    Date start_date;

    @Expose
    Date end_date;

    @Expose
    String poster_link;

    @Expose
    @SerializedName("university")
    long university_id;


    public Festival(){
    }

    public Festival(long externalId, long max_pages, String university_name, String name, Date start_date, Date end_date, String poster_link, long university_id) {
        this.externalId = externalId;
        this.max_pages = max_pages;
        this.university_name = university_name;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.poster_link = poster_link;
        this.university_id = university_id;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public long getMax_pages() {
        return max_pages;
    }

    public void setMax_pages(long max_pages) {
        this.max_pages = max_pages;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getPoster_link() {
        return poster_link;
    }

    public void setPoster_link(String poster_link) {
        this.poster_link = poster_link;
    }

    public long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(long university_id) {
        this.university_id = university_id;
    }
}
