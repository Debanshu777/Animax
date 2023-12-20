//
//  LocalGridView.swift
//  iosApp
//
//  Created by Debanshu Datta on 18/12/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI

struct LocalGridView: View {
    @EnvironmentObject var viewModel: AppViewModel
    @State var uiState: AnimeLocalState = AnimeLocalStateUninitialized()
    
    var animeData: [LocalAnimeEntity] = []
    
    private let adaptaiveColumns = [
        GridItem(.adaptive(minimum: 170))
    ]
    
    var body: some View {
        let appUiState = viewModel.animeLocalState
        NavigationView{
            VStack{
                switch(uiState){
                case is AnimeLocalStateLoading:
                    LoadingView()
                case let successState as AnimeLocalStateSuccess:
                    ScrollView{
                        LazyVGrid(columns: adaptaiveColumns, spacing: 20){
                            ForEach(successState.data, id: \.id) { anime in
                                AnimeGridLocalItem(
                                    onClick: {
                                        viewModel.deleteAnimeById(id: anime.id as! Int64)
                                    }, anime:anime)
                            }
                        }
                    }
                case is AnimeLocalStateError:
                    ErrorView()
                default:
                    ErrorView()
                }
            }.padding([.horizontal])
                .navigationTitle("Favourite")
                .task {
                    appUiState.subscribe { state in
                        self.uiState = state!
                    }
                    viewModel.loadLocalAnime()
                }
        }
    }
}

#Preview {
    LocalGridView()
}
