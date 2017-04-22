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
    
    @IBOutlet weak var univCollectionView: UICollectionView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        univCollectionView.delegate = self
        univCollectionView.dataSource = self
    }
    
    
    @IBAction func didTapSearchButton(_ sender: UIBarButtonItem) {
        let toast = Toast(text: "보다 나은 서비스를 위해 개발중입니다.", duration: Delay.short)
        toast.show()
    }
    
    
    
}
extension ViewController: UICollectionViewDelegate, UICollectionViewDataSource,UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 9
    }
    
    // make a cell for each cell index path
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        // get a reference to our storyboard cell
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "univCell", for: indexPath as IndexPath) 
        
        
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
