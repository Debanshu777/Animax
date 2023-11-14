package com.debanshu.animax.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import com.debanshu.animax.data.AnimeListState
import com.debanshu.animax.data.AppViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                GridViewAnime()
            }
        }
    }
}

@Composable
fun GridViewAnime(viewModel: AppViewModel = getViewModel()) {
    val animeState by viewModel.animeState.collectAsStateWithLifecycle()

    Scaffold(topBar = {
        TopAppBar {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Animax")
            }
        }
    }) { defaultPadding ->
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
                    modifier = Modifier.padding(defaultPadding),
                    columns = GridCells.Adaptive(170.dp)
                ) {
                    items((animeState as AnimeListState.Success).data) { anime ->
                        Column {
                            AsyncImage(
                                model = anime.images.jpg.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                                    .height(220.dp)
                                    .width(170.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            anime.titleEnglish?.let {
                                Text(
                                    modifier = Modifier.padding(
                                        start = 20.dp,
                                        end = 20.dp
                                    ),
                                    text = it, fontSize = 12.sp,
                                )
                            }
                        }
                    }
                }
            }

            is AnimeListState.Error->{
                Text(text = "Error Occurred ${(animeState as AnimeListState.Error).exceptionMessage} ")
            }
            is AnimeListState.Uninitialized->{
                Text(text = "Error Occurred in initialization")
            }
        }
    }
}