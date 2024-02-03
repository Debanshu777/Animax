//
//  AnimeGridItem.swift
//  iosApp
//
//  Created by Debanshu Datta on 01/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import MultiPlatformLibrary
import SDWebImageSwiftUI

struct AnimeGridItem: View {
    let anime: Anime
    let onClick:()->Void
    init(onClick: @escaping ()->Void, anime:Anime){
        self.onClick = onClick
        self.anime = anime
    }
    var body: some View {
        VStack(alignment: .leading) {
            AnimatedImage(url: URL(string: anime.images.jpg.imageUrl))
                .resizable()
                .scaledToFill()
                .frame(width:170,height: 220)
                .cornerRadius(10)
            HStack{
                Text(anime.titleEnglish!)
                    .font(.system(size: 12, weight: .semibold))
                    .lineLimit(2)
                Button(action: {
                    self.onClick()
                }) {
                    Image(systemName: true ? "heart.fill" : "heart")
                }
            }
            
        }
        
    }
    
}

struct AnimeGridLocalItem: View {
    let anime: LocalAnimeEntity
    let onClick:()->Void
    init(onClick: @escaping ()->Void, anime:LocalAnimeEntity){
        self.onClick = onClick
        self.anime = anime
    }
    var body: some View {
        VStack(alignment: .leading) {
            AnimatedImage(url: URL(string: anime.imageUrl))
                .resizable()
                .scaledToFill()
                .frame(width:170,height: 220)
                .cornerRadius(10)
            HStack{
                Text(anime.title)
                    .font(.system(size: 12, weight: .semibold))
                    .lineLimit(2)
                Button(action: {
                    self.onClick()
                }) {
                    Image(systemName: true ? "heart.fill" : "heart")
                }
            }
            
        }
        
    }
    
}

