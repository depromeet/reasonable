//
//  AlamofireManager.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 29..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON
import Toaster

class AlamofireManager {
    static let shared = AlamofireManager()
    
    let mainServer = Constants.serverAddress
    
    /// 관객 정보를 서버에 보낸다.
    func getListFestival(page: Int, completion: ((_ resultJSON: JSON) -> Void)?) {
        let pageString = String(page)
        let baseURL = "\(mainServer)/festival/list/\(pageString)"
        
        
        Alamofire.request(baseURL, method: .get).responseJSON { response in
            
            print("------------getListFestival 결과")
            print(response.request)  // original URL request
            print(response.response) // HTTP URL response
            print(response.data)     // server data
            print(response.result)   // result of response serialization
            if let JSON = response.result.value {
                print("JSON: \(JSON)")
            }
            print("------------getListFestival 결과 끝")
            
            let statusCode = (response.response?.statusCode)!
            
            switch statusCode {
            case 200:
                completion
            default:
                Toast(text: "축제 목록을 불러오는데 실패했습니다.").show()
                break
            }
            
            
        }
    }
    
    
}
