//
//  UnivCell.swift
//  Reasonable
//
//  Created by Goodnews on 2017. 4. 22..
//  Copyright © 2017년 Depromeet. All rights reserved.
//

import UIKit

class UnivCell: UICollectionViewCell {
    
    @IBOutlet weak var univLogoImgView: UIImageView!
    
    
    private func setupView() {
        univLogoImgView.layer.cornerRadius = 8
        univLogoImgView.backgroundColor = .cyan
    }

    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    }
