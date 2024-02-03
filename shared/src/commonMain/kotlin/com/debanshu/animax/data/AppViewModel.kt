package com.debanshu.animax.data

import com.debanshu.animax.data.domain.LocalAnimeEntity
import com.debanshu.animax.data.model.Anime
import com.debanshu.animax.data.usecase.AddLocalAnimeUseCase
import com.debanshu.animax.data.usecase.DeleteLocalAnimeByIdUseCase
import com.debanshu.animax.data.usecase.GetLocalAnimeUseCase
import com.debanshu.animax.data.usecase.GetTopAnimeUseCase
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val getTopAnimeUseCase: GetTopAnimeUseCase,
    private val getLocalAnimeUseCase: GetLocalAnimeUseCase,
    private val addLocalAnimeUseCase: AddLocalAnimeUseCase,
    private val deleteLocalAnimeByIdUseCase: DeleteLocalAnimeByIdUseCase,
) : ViewModel() {
    private val animeMutable =
        MutableStateFlow<AnimeListState>(AnimeListState.Uninitialized)
    private val animeLocalMutable =
        MutableStateFlow<AnimeLocalState>(AnimeLocalState.Uninitialized)

    val animeState = animeMutable.asStateFlow().cStateFlow()
    val animeLocalState = animeLocalMutable.asStateFlow().cStateFlow()

    init {
        loadRemoteAnime()
        loadLocalAnime()
    }

    fun createDummyData(id: Long, title:String, imageUrl:String){
        viewModelScope.launch {
            addLocalAnimeUseCase.execute(id,title,imageUrl)
        }
    }

    fun deleteAnimeById(id:Long){
        viewModelScope.launch {
            deleteLocalAnimeByIdUseCase.execute(id)
        }
    }
    private fun loadRemoteAnime() {
        animeMutable.value = AnimeListState.Loading
        viewModelScope.launch {
            try {
                animeMutable.value = AnimeListState.Success(getTopAnimeUseCase.execute(Unit).data)
            } catch (e: Exception) {
                e.printStackTrace()
                animeMutable.value = AnimeListState.Error(e.message.orEmpty())
            }
        }
    }

    fun loadLocalAnime() {
        animeLocalMutable.value = AnimeLocalState.Loading
        viewModelScope.launch {
            try {
                animeLocalMutable.value = AnimeLocalState.Success(getLocalAnimeUseCase.execute())
            } catch (e: Exception) {
                e.printStackTrace()
                animeLocalMutable.value = AnimeLocalState.Error(e.message.orEmpty())
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}

sealed interface AnimeListState {
    data class Success(val data: List<Anime>) : AnimeListState
    data class Error(val exceptionMessage: String) : AnimeListState
    data object Loading : AnimeListState
    data object Uninitialized : AnimeListState
}

sealed interface AnimeLocalState {
    data class Success(val data: Flow<List<LocalAnimeEntity>>) : AnimeLocalState
    data class Error(val exceptionMessage: String) : AnimeLocalState
    data object Loading : AnimeLocalState
    data object Uninitialized : AnimeLocalState
}