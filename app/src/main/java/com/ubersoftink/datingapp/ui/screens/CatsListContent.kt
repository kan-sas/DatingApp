package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.data.models.CatResponse

@Composable
fun CatsListContent(
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
@Preview
private fun CatItemPreview(){
    val cat = CatResponse(
        id = "1L",
        picUrl = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
        width = 1,
        height = 1
    )
    CatCard(cat = cat)
}

@Preview(showBackground = true)
@Composable
private fun CatsListScreenPreview(){
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
    CatsListContent(catResponses = cats)
}