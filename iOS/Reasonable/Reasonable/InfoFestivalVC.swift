//
//  InfoFestivalVC.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 22..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import UIKit

class InfoFestivalVC: UIViewController {

    
    
    let scrollView: UIScrollView = {
        let sv = UIScrollView()
        
        return sv
        
    }()
    let dismissButton: UIButton = {
        let button = UIButton()
        button.setTitle("닫기", for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.backgroundColor = .black
        button.addTarget(self, action: #selector(dismissVC), for: .touchUpInside)
        return button
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
        
    }
    
    @objc private func dismissVC() {
        print("창닫자")
        dismiss(animated: true, completion: nil)
    }

}
