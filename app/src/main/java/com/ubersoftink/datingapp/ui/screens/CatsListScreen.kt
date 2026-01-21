package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel
import com.ubersoftink.datingapp.utils.NetworkResult

@Composable
fun CatsListScreen(
    modifier: Modifier = Modifier,
    catViewModel: CatsListViewModel,
){
    val catListUi = catViewModel.catListUi.collectAsState().value

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when (catListUi) {
            is NetworkResult.Success -> {
                SuccessScreen(catResponses = catListUi.data ?: listOf())
            }

            is NetworkResult.Error -> {
                ErrorScreen(catListUi.message ?: "Unknown error!\nSomething went wrong :-(")
            }

            is NetworkResult.Loading -> {
                LoadingScreen()
            }
        }
    }
}

@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier,
    catResponses: List<CatResponse>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    ){
    LazyVerticalGrid(
        columns = GridCells.FixedSize(size = 190.dp),
        modifier =modifier
            .padding(horizontal = 4.dp)
            .fillMaxSize()
        ,
        contentPadding = contentPadding,
    ) {
        items(items = catResponses, key = {catResponse-> catResponse.id}){ catResponse ->
            CatCard(cat = catResponse)
        }
    }
}

@Composable
fun CatCard(
    modifier: Modifier = Modifier,
    cat: CatResponse,
){
    Card(
        modifier = modifier.padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(cat.picUrl)
                .crossfade(true).build(),
            error = painterResource(R.drawable.ic_connection_error),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.cat_picture),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ErrorScreen(message: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = message, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red)
    }
}

@Composable
fun LoadingScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview(){
    LoadingScreen()
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview(){
    val cats = listOf(
        CatResponse(
            id = "1L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "2L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "3L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "4L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "5L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "6L",
            picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
    )
    SuccessScreen(catResponses = cats)
}

@Composable
@Preview
fun CatItemPreview(){
    val cat = CatResponse(
        id = "1L",
        picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
        width = 1,
        height = 1
    )
    CatCard(cat = cat)
}