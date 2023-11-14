import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI

struct GridViewAnime: View {
    @ObservedObject var viewModel: AppViewModel = KoinHelper().getAppViewModel()
    @State var uiState: AnimeListState = AnimeListStateUninitialized()
    
    private let adaptaiveColumns = [
        GridItem(.adaptive(minimum: 170))
    ]
   

    var body: some View {
        let appUiState = viewModel.animeState
        NavigationView{
            VStack{
                switch(uiState){
                case is AnimeListStateLoading:
                    LoadingView()
                case let successState as AnimeListStateSuccess:
                    ScrollView{
                        LazyVGrid(columns: adaptaiveColumns, spacing: 20){
                            ForEach(successState.data,id: \.self){ anime in
                                AnimeGridItem(anime:anime)
                            }
                        }
                    }
                case is AnimeListStateError:
                    ErrorView()
                default:
                    ErrorView()
                }
            }
            .padding([.horizontal])
            .navigationTitle("Animax")
        }.onAppear {
            appUiState.subscribe { state in
                self.uiState = state!
            }
        }
	}
}

struct LoadingView: View {
    var body: some View {
        ProgressView()
            .padding()
    }
}

struct ErrorView: View {
    var body: some View {
        Text("An error occurred. Please try again.")
            .foregroundColor(.red)
            .padding()
    }
}

struct GridViewAnime_Previews: PreviewProvider {
	static var previews: some View {
		GridViewAnime()
	}
}
