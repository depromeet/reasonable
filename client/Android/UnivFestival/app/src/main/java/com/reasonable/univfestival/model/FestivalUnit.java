package com.reasonable.univfestival.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class FestivalUnit extends SugarRecord {
    /**
     * Festival Unit
     - id
     - artist_id
     - start_time
     - end_time
     - festival_id
     */
    long id;
    long artist_id;
    Date start_time;
    Date end_time;
    long festival_id;

    public FestivalUnit() {
    }

    public FestivalUnit(long id, long artist_id, Date start_time, Date end_time, long festival_id) {
        this.id = id;
        this.artist_id = artist_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.festival_id = festival_id;
    }
}
