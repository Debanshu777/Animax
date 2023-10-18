package com.debanshu.animax.data

import com.debanshu.animax.data.model.Anime
import com.debanshu.animax.data.usecase.GetTopAnimeUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val getTopAnimeUseCase: GetTopAnimeUseCase) : ViewModel() {
    private val animeMutable =
        MutableStateFlow<AnimeListState>(AnimeListState.Uninitialized)
    val animeState = animeMutable.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
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
    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}

sealed interface AnimeListState {
    data class Success(val data: List<Anime>) : AnimeListState
    data class Error(val exceptionMessage: String) : AnimeListState
    object Loading : AnimeListState
    object Uninitialized : AnimeListState
}