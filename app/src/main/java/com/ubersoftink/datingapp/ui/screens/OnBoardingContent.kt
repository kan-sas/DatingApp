package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.ui.theme.backgroundLight
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark
import com.ubersoftink.datingapp.ui.theme.primaryContainerDarkMediumContrast
import com.ubersoftink.datingapp.ui.theme.surfaceDimLightHighContrast
import kotlin.math.absoluteValue

@Composable
fun OnBoardingContent(
    modifier: Modifier = Modifier,
    catResponses: List<CatResponse>,
    onCreateAccountButton: () -> Unit,
    onAuthButton: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { catResponses.take(3).size })
    val titles = listOf(
        stringResource(R.string.algorithm),
        stringResource(R.string.matches),
        stringResource(R.string.premium),
    )
    val desc = listOf(
        stringResource(R.string.users_going_a_vetting_process_to_ensure_you_never_match_with_bots),
        stringResource(R.string.we_match_you_with_people),
        stringResource(R.string.sign_up_today_and_enjoy_the_first_month),
    )

    Column(
        modifier = modifier.fillMaxSize().padding(bottom = 60.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 55.dp),
        ) { page ->
            Column(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PageContent(
                    modifier = modifier,
                    page = page,
                    pagerState = pagerState,
                    catResponses = catResponses,
                    titles = titles,
                    desc = desc,
                )
            }
        }
        Button(
            onClick = { onCreateAccountButton },
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(primaryContainerDark),
        ) {
            Text(
                text = stringResource(R.string.create_an_account),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(8.dp)
            )
        }
        Row(
            modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = stringResource(R.string.already_have_an_account),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.labelLarge,
                modifier = modifier.padding(end = 4.dp, bottom = 14.dp),
            )
            Card(
                onClick = onAuthButton,
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    style = MaterialTheme.typography.labelLarge,
                    color = primaryContainerDark,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    page: Int,
    pagerState: PagerState,
    catResponses: List<CatResponse>,
    titles: List<String>,
    desc: List<String>,
){
    val pageOffset = pagerState.getOffsetDistanceInPages(page).absoluteValue

    Card(
        modifier = modifier
            .height(375.dp * (1 - pageOffset / 3))
            .width(250.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(catResponses[page].url)
                .crossfade(true).build(),
            error = painterResource(R.drawable.ic_connection_error),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.cat_picture),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
    }
    Text(
        text = titles[page],
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, top = 48.dp),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        color = primaryContainerDark
    )
    Text(
        text = desc[page],
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Normal,
        modifier = modifier
            .graphicsLayer(
                alpha = lerp(
                    start = 0f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            ),
        color = MaterialTheme.colorScheme.onBackground,
    )
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) primaryContainerDarkMediumContrast else surfaceDimLightHighContrast
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun OnBoardingPreview(){
    val cats = listOf(
        CatResponse(
            id = "1L",
            url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "2L",
            url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
        CatResponse(
            id = "3L",
            url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
            width = 1,
            height = 1
        ),
    )
    OnBoardingContent(
        catResponses = cats,
        onCreateAccountButton = {},
        onAuthButton = {}
    )
}