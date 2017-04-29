//
//  ViewController.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 22..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import UIKit
import Alamofire
import SwiftyJSON
import Toaster

class ViewController: UIViewController {
    
    @IBOutlet weak var festivalCollectionView: UICollectionView!
    
    var festivals = [Festival]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setNavigationTitleImage(named: "appLogo")

        
        festivalCollectionView.delegate = self
        festivalCollectionView.dataSource = self
        festivalCollectionView.register(FestivalCell.self, forCellWithReuseIdentifier: "festivalCell")
        getListFestival(page: 1)
    }
    
    
    @IBAction func didTapSearchButton(_ sender: UIBarButtonItem) {
        let toast = Toast(text: "보다 나은 서비스를 위해 개발중입니다.", duration: Delay.short)
        toast.show()
    }
    
    private func getListFestival(page: Int) {
        let pageString = String(page)
        let baseURL = "\(Constants.serverAddress)/festival/list/\(pageString)"
        
        
        Alamofire.request(baseURL, method: .get).responseJSON { response in
            
//                        print("------------getListFestival 결과")
//                        print(response.request)  // original URL request
//                        print(response.response) // HTTP URL response
//                        print(response.data)     // server data
//                        print(response.result)   // result of response serialization
//                        if let JSON = response.result.value {
//                            print("JSON: \(JSON)")
//                        }
//                        print("------------getListFestival 결과 끝")
            
            let statusCode = (response.response?.statusCode)!
            
            guard let resultData = response.result.value else {
                Toast(text: "축제 목록 결과값을 찾을 수 없습니다.").show()
                return
            }
            
            switch statusCode {
            case 200:
                let jsonData = JSON(resultData)
                self.setListFestival(with: jsonData)
            default:
                Toast(text: "축제 목록을 불러오는데 실패했습니다.").show()
                break
            }
        }
        
    }
    
    private func setListFestival(with data: JSON) {
        let festivalDataArray = data.arrayValue
        for festData in festivalDataArray {
            festivals.append(Festival(festData))
        }
        festivalCollectionView.reloadData()
    }
    
    /// 네비게이션바 타이틀을 로고 이미지로 바꾼다.
    func setNavigationTitleImage(named imgName: String) {
        let imageView = UIImageView(image: UIImage(named: imgName))
        imageView.contentMode = UIViewContentMode.scaleAspectFill
        let titleView = UIView(frame: CGRect(x: 0, y: 0, width: 40, height: 20))
        imageView.frame = titleView.bounds
        titleView.addSubview(imageView)
        
        self.navigationItem.titleView = titleView
    }
}


extension ViewController: UICollectionViewDelegate, UICollectionViewDataSource,UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return festivals.count
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: 120, height: 180)
    }
    
    // make a cell for each cell index path
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "festivalCell", for: indexPath) as! FestivalCell
        cell.festival = festivals[indexPath.item]
        
        return cell
    }   // 셀의 내용
    
    
    
    // 헤더랑 푸터 집어넣기
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if kind == UICollectionElementKindSectionHeader {
            let header = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "univHeader", for: indexPath)
            return header
        } else {
            let footer = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "univFooter", for: indexPath)
            return footer
        }
    }
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        let storyboard = self.storyboard
        let infoVC = storyboard?.instantiateViewController(withIdentifier: "infoFestivalVC")
        popUpVC(infoVC)
        
    }
    
    func popUpVC(_ controller: UIViewController?) {
        guard (controller != nil) else {
            print("---ERROR: 팝업을 실행할 수 없습니다. 컨트롤러가 없어서요.")
            return
        }
        
        controller?.modalPresentationStyle = .overCurrentContext
        present(controller!, animated: true, completion: nil)
    }
    
    
    
    
}
