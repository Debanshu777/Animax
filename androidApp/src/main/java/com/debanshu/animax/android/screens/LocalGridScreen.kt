package com.debanshu.animax.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.debanshu.animax.data.AnimeLocalState
import com.debanshu.animax.data.AppViewModel

@Composable
fun LocalViewAnime(viewModel: AppViewModel) {
    val animeState by viewModel.animeLocalState.collectAsStateWithLifecycle()

    Surface {
        when (animeState) {
            is AnimeLocalState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is AnimeLocalState.Success -> {
                val animeList by (animeState as AnimeLocalState.Success).data.collectAsStateWithLifecycle(
                    emptyList()
                )
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(170.dp)
                ) {
                    items(animeList) { anime ->
                        Column {
                            AsyncImage(
                                model = anime.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                                    .height(220.dp)
                                    .width(170.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            Row(
                                modifier = Modifier.width(170.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    modifier = Modifier.padding(
                                        start = 20.dp,
                                        end = 20.dp
                                    ),
                                    text = anime.title, fontSize = 12.sp,
                                )
                                Icon(
                                    modifier = Modifier.size(20.dp).clickable {
                                        anime.id?.let {
                                            viewModel.deleteAnimeById(
                                                it
                                            )
                                        }
                                    },
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = anime.title,
                                )
                            }
                        }
                    }
                }
            }

            is AnimeLocalState.Error -> {
                Text(text = "Error Occurred ${(animeState as AnimeLocalState.Error).exceptionMessage} ")
            }

            is AnimeLocalState.Uninitialized -> {
                Text(text = "Error Occurred in initialization")
            }
        }
    }
}
