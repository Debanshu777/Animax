package com.debanshu.animax.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.debanshu.animax.data.AnimeListState
import com.debanshu.animax.data.AppViewModel


@Composable
fun GridViewAnime(viewModel: AppViewModel) {
    val animeState by viewModel.animeState.collectAsStateWithLifecycle()

    Surface {
        when (animeState) {
            is AnimeListState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is AnimeListState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(170.dp)
                ) {
                    items((animeState as AnimeListState.Success).data) { anime ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            AsyncImage(
                                model = anime.images.jpg.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(220.dp)
                                    .width(170.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            anime.titleEnglish?.let {
                                Row(
                                    modifier = Modifier.width(170.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        modifier = Modifier.weight(0.75f),
                                        text = it,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 12.sp,
                                    )
                                    Icon(
                                        modifier = Modifier.size(20.dp).clickable {
                                            anime.malId?.let { id ->
                                                 viewModel.createDummyData(
                                                    id.toLong(),
                                                    anime.titleEnglish!!,
                                                    anime.images.jpg.imageUrl,
                                                )
                                            }
                                        },
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = it,
                                    )
                                }
                            }
                        }
                    }
                }
            }

            is AnimeListState.Error -> {
                Text(text = "Error Occurred ${(animeState as AnimeListState.Error).exceptionMessage} ")
            }

            is AnimeListState.Uninitialized -> {
                Text(text = "Error Occurred in initialization")
            }
        }
    }
}
