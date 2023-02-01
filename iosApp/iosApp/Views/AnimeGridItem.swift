//
//  AnimeGridItem.swift
//  iosApp
//
//  Created by Debanshu Datta on 01/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import SDWebImageSwiftUI

struct AnimeGridItem: View {
    let anime: Anime
    var body: some View {
        VStack(alignment: .leading) {
            AnimatedImage(url: URL(string: anime.images.jpg.imageUrl))
                        .resizable()
                        .scaledToFill()
                        .frame(width:170,height: 220)
                        .cornerRadius(10)
            Text(anime.titleEnglish!)
                .font(.system(size: 12, weight: .semibold))
                .lineLimit(2)
                
        }
        
    }
            
}

