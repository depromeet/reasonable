//
//  InfoFestivalVC.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 22..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import UIKit

class InfoFestivalVC: UIViewController {

    
    // 스크롤뷰
    let scrollView: UIScrollView = {
        let sv = UIScrollView()
        
        return sv
        
    }()
    
    // 닫기버튼
    let dismissButton: UIButton = {
        let button = UIButton()
        button.setTitle("닫기", for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.backgroundColor = .black
        button.addTarget(self, action: #selector(dismissVC), for: .touchUpInside)
        return button
    }()
    
    // 스크롤뷰에 들어가는 포스터
    let posterImageView: UIImageView = {
        let iv = UIImageView()
        iv.image = UIImage(named: "posterFestival.jpg")
        
        iv.contentMode = .scaleAspectFit
        return iv
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupViews()
    }

    private func setupViews() {
        self.view.addSubview(scrollView)
        self.view.addSubview(dismissButton)
    
        let vWidth = self.view.frame.width
        let vHeight = self.view.frame.height
        
        scrollView.frame = CGRect(x: 0, y: 0, width: vWidth, height: vHeight - 44)
        dismissButton.frame = CGRect(x: 0, y: vHeight, width: vWidth, height: -44)
        
        //-------------- 이 아래로는 스크롤뷰세팅
        scrollView.addSubview(posterImageView)
        
        posterImageView.frame = CGRect(x: 24, y: 24, width: vWidth - 48, height: 400)
        
        scrollView.contentSize = CGSize(width: vWidth, height: vHeight * 1.5)
        
    }
    
    @objc private func dismissVC() {
        print("창닫자")
        dismiss(animated: true, completion: nil)
    }

}
