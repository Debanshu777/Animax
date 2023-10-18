import SwiftUI
import shared

struct GridViewAnime: View {
    @State private var topAnimeList:[Anime]=[]
    private let adaptaiveColumns = [
        GridItem(.adaptive(minimum: 170))
    ]
	var body: some View {
        NavigationView{
            ScrollView{
                LazyVGrid(columns: adaptaiveColumns, spacing: 20){
                    ForEach(topAnimeList,id: \.self){ anime in
                        AnimeGridItem(anime:anime)
                    }
                }
            }
            .padding([.horizontal])
            .navigationTitle("Animax")
        }.onAppear{
            GetTopAnimeUseCase().execute(request: KotlinUnit()){ topAnimeRespose, error in
                guard let animeList = topAnimeRespose?.data else {return}
                DispatchQueue.main.async {
                    self.topAnimeList=animeList
                }
            }
        }
	}
}

struct GridViewAnime_Previews: PreviewProvider {
	static var previews: some View {
		GridViewAnime()
	}
}
