//
//  Festival.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 29..
//  Copyright © 2017년 Depromeet. All rights reserved.
//


/*
 "id": 17,
 "max_pages": 1,
 "university_id": 2,
 "university_name": "가톨릭대학교",
 "name": "2016 가톨릭대학교 축제",
 "start_date": "2016-05-08T15:00:00",
 "end_date": "2016-05-11T15:00:00",
 "poster_link": "#",
 "university": 2
*/
import Foundation
import SwiftyJSON

class Festival {
    
    var id: Int?
    var festName: String?
    
    var univID: Int?
    var univName: String?
    
    var startDateString: String?
    var endDateString: String?
    
    var posterLink: String?
    
    init(_ data: JSON) {
        print(data)
        self.id = data["id"].int
        self.festName = data["name"].string
        
        self.univID = data["university_id"].int
        self.univName = data["university_id"].string
        
        self.startDateString = data["start_date"].string
        self.endDateString = data["end_date"].string
    }
    
}
