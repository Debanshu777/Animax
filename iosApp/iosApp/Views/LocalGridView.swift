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
    
    var body: some View {
        let appUiState = viewModel.animeLocalState
        NavigationView{
            VStack{
                switch(uiState){
                case is AnimeLocalStateLoading:
                    LoadingView()
                case let successState as AnimeLocalStateSuccess:
                    SuccessView(data: successState.data) { id in
                        viewModel.deleteAnimeById(id: id)
                    }
                case is AnimeLocalStateError:
                    ErrorView()
                default:
                    ErrorView()
                }
            }
            .padding([.horizontal])
            .navigationTitle("Animax")
        }.task {
            appUiState.subscribe { state in
                self.uiState = state!
            }
        }
    }
}

struct SuccessView: View {
    let data: SkieSwiftFlow<[LocalAnimeEntity]>
    let deleteAnimeById: (Int64) -> Void

    private let adaptaiveColumns = [
        GridItem(.adaptive(minimum: 170))
    ]

    @State
    private var items: [LocalAnimeEntity] = []

    var body: some View {
        ScrollView {
            LazyVGrid(columns: adaptaiveColumns, spacing: 20) {
                ForEach(items, id: \.id) { anime in
                    AnimeGridLocalItem(
                        onClick: { deleteAnimeById(anime.id as! Int64) },
                        anime:anime
                    )
                }
            }
        }
        .task {
               // Reset items as this is called each time this view appears and we don't want duplicates
            items = []
            for await item in data {
                items = item
            }
        }
    }
}


#Preview {
    LocalGridView()
}
