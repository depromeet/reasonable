package com.reasonable.univfestival.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by jkimab on 2017. 4. 22..
 */

public class Festival extends SugarRecord {
    /**
     * Festival
     - id
     - univ_id
     - start_date
     - end_date
     */
    long id;
    long univ_id;
    Date start_date;
    Date end_date;

    public Festival(){
    }

    public Festival(long id, long univ_id, Date start_date, Date end_date) {
        this.id = id;
        this.univ_id = univ_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
