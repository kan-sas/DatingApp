package com.ubersoftink.datingapp.ui.screens.profiledetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.components.ButtonWithText
import com.ubersoftink.datingapp.ui.components.ClickableText
import com.ubersoftink.datingapp.ui.components.NavigateBackButton
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight
import com.ubersoftink.datingapp.ui.viewmodels.RegistrationViewModel
import com.ubersoftink.datingapp.utils.Interest

@Composable
fun InterestsScreen(
    onBackClick: () -> Unit,
    onSkipClick: () -> Unit,
    onContinueClick: () -> Unit ,
    viewModel: RegistrationViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val subtitleColor = Color(0xFF6B7280)

    val interests = Interest.entries.toTypedArray()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 40.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigateBackButton(
                navigateUp = onBackClick,
                contentDescription = stringResource(R.string.back_to_profile_details),
                modifier = Modifier
                    .size(55.dp),
            )
            ClickableText(
                onClick = onSkipClick,
                text = stringResource(R.string.skip),
                style = AppTypography.titleLarge,
            )
        }
        Spacer(Modifier.padding(20.dp))
        Text(
            text = stringResource(R.string.your_interests),
            style = MaterialTheme.typography.displaySmall,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.select_a_few_of_your_interests_and_let_everyone_know_what_you_re_passionate_about),
            style = MaterialTheme.typography.bodyMedium,
            color = subtitleColor,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )

        Spacer(Modifier.padding(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = false),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = false
        ) {
            items(interests) { item ->
                val isSelected = state.bio.contains(item.title)

                InterestChipItem(
                    item = item,
                    isSelected = isSelected,
                    onSelected = { viewModel.updateInterests(item.title) },
                )
            }
        }
        Spacer(Modifier.padding(48.dp))
        ButtonWithText(
            onClick = onContinueClick,
            text = stringResource(R.string.continue_),
            modifier = Modifier.height(56.dp)
        )
    }
}

@Composable
private fun InterestChipItem(
    isSelected: Boolean = false,
    item: Interest,
    onSelected: (String) -> Unit,
) {
    val primaryColor = primaryContainerLight
    val shape = RoundedCornerShape(15.dp)

    val containerModifier = if (isSelected) {
        Modifier
            .shadow(
                elevation = 8.dp,
                shape = shape,
                ambientColor = primaryColor.copy(alpha = 0.35f),
                spotColor = primaryColor.copy(alpha = 0.35f)
            )
            .clip(shape)
            .background(primaryColor)
    } else {
        Modifier
            .clip(shape)
            .background(Color.Transparent)
            .border(1.dp, Color.LightGray, shape)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .then(containerModifier)
            .clickable { onSelected(item.title) }
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = if (isSelected) Color.White else primaryColor,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = item.title,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview(showBackground = true)
fun InterestsScreenPreview(){
    InterestsScreen(
        onBackClick = {},
        onSkipClick = {},
        onContinueClick = {}
    )
}