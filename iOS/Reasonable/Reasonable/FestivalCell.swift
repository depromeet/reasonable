//
//  FestivalCell.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 29..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import UIKit

class FestivalCell: UICollectionViewCell {
    var festival: Festival? {
        didSet {
            setupViews()
        }
    }

//    @IBOutlet weak var logoImgView: UIImageView!
//    @IBOutlet weak var nameLabel: UILabel!
//    @IBOutlet weak var periodLabel: UILabel!
//    
    let logoImgView: UIImageView = {
        let iv = UIImageView()
        iv.image = UIImage(named: "logoUniv.png")
        return iv
    }()
    
    let nameLabel: UILabel = {
        let label = UILabel()
        label.text = "0000 디프만대학교 축제"
        label.textAlignment = .center
        label.numberOfLines = 2
        label.font = label.font.withSize(14)
        return label
    }()
    
    let periodLabel: UILabel = {
        let label = UILabel()
        label.text = "0000.00.00 ~ 00"
        label.textAlignment = .center
        label.font = label.font.withSize(10)
        label.textColor = UIColor.darkGray
        return label
    }()
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
//        setupViews()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupViews() {

        addSubview(logoImgView)
        addSubview(nameLabel)
        addSubview(periodLabel)
        
        logoImgView.frame = CGRect(x: 4, y: 4, width: 112, height: 112)
        nameLabel.frame = CGRect(x: 4, y: 120, width: 112, height: 40)
        periodLabel.frame = CGRect(x: 4, y: 160, width: 112, height: 16)
        
        
        nameLabel.text = festival?.festName
        periodLabel.text = festival?.startDateString
    }
}
