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

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
