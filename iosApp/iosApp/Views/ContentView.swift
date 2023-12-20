//
//  ContentView.swift
//  iosApp
//
//  Created by Debanshu Datta on 18/12/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import MultiPlatformLibrary

struct ContentView: View {
    @ObservedObject var viewModel: AppViewModel = KoinHelper().getAppViewModel()
    
    var body: some View {
        TabView {
            GridViewAnime().tabItem {
                Image(systemName: "house")
                Text("Home")
            }
            LocalGridView().tabItem {
                Image(systemName: "heart")
                Text("Favourite")
            }
        }.environmentObject(viewModel)
    }
}

#Preview {
    ContentView()
}
