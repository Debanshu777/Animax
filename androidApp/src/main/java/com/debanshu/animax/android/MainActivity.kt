package com.debanshu.animax.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.debanshu.animax.model.Anime
import com.debanshu.animax.usecase.GetTopAnimeUseCase

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
fun GridViewAnime() {
    val scope = rememberCoroutineScope()
    var animeList by remember {
        mutableStateOf(emptyList<Anime>())
    }
    LaunchedEffect(true) {
        scope.runCatching {
            GetTopAnimeUseCase().execute(Unit)
        }.onSuccess { remoteAnime ->
            animeList = remoteAnime.data
        }.onFailure {
            Log.d("Failed", "Network error")
        }
    }
    Scaffold(topBar = {
        TopAppBar {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Products")
            }
        }
    }) { defaultPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(defaultPadding),
            columns = GridCells.Adaptive(170.dp)
        ) {
            items(animeList) { anime ->
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
                            ), text = it, fontSize = 12.sp,
                        )
                    }
                }
            }
        }
    }
}