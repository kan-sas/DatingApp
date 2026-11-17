package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DisplaySettings
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.ubersoftink.datingapp.ui.components.NavigateBackButton
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight


@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    catsList: List<CatResponse>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigateBackButton(
                navigateUp = onBackClick,
                contentDescription = stringResource(R.string.back_to_profile_details),
                modifier = Modifier
                    .size(55.dp),
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Discover",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Chicago, IL",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Transparent)
                    .border(
                        border = BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.DisplaySettings,
                    contentDescription = "Filters",
                    tint = primaryContainerLight,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        val currentCat = catsList.firstOrNull()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(24.dp))
        ) {
            if (currentCat != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(currentCat.url)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.cat_picture),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                            startY = 400f
                        )
                    )
            )

            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart),
                shape = RoundedCornerShape(20.dp),
                color = Color.Black.copy(alpha = 0.4f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.loading_img), // Иконка локации
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "1 km",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterEnd),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                repeat(5) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == 0) 6.dp else 4.dp)
                            .clip(CircleShape)
                            .background(if (index == 0) Color.White else Color.White.copy(alpha = 0.5f))
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Whiskers, 2",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Professional mouser",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(64.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Dislike",
                        tint = Color(0xFFE94057),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Surface(
                modifier = Modifier.size(80.dp),
                shape = CircleShape,
                color = primaryContainerLight,
                shadowElevation = 8.dp
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Like",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Surface(
                modifier = Modifier.size(64.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Super Like",
                        tint = Color(0xFF8A2387),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    MainScreenContent(
        catsList = listOf(
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
            CatResponse(
                id = "4L",
                url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
                width = 1,
                height = 1
            ),
            CatResponse(
                id = "5L",
                url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
                width = 1,
                height = 1
            ),
            CatResponse(
                id = "6L",
                url = "https://cdn2.thecatapi.com/images/MTU1MTczMQ.jpg",
                width = 1,
                height = 1
            ),
        ),
        onBackClick = {}
    )
}