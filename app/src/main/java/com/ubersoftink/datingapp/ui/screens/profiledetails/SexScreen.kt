package com.ubersoftink.datingapp.ui.screens.profiledetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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

enum class Gender(val sex: String){
    MALE("Male"),
    FEMALE("Female"),
    OTHER("unknown")   //Добавть потом по возможности, если надо будет (опционально)
}

@Composable
fun SexScreen(
    viewModel: RegistrationViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onSkipClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
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
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = stringResource(R.string.i_am_a),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.padding(vertical = 48.dp)
            )

            GenderOptionItem(
                text = Gender.FEMALE.sex,
                isSelected = state.selectedGender == Gender.FEMALE.sex,
                isCustomChoice = false,
                onClick = { viewModel.onGenderSelected(Gender.FEMALE.sex) }
            )
            GenderOptionItem(
                text = Gender.MALE.sex,
                isSelected = state.selectedGender == Gender.MALE.sex,
                isCustomChoice = false,
                onClick = { viewModel.onGenderSelected(Gender.MALE.sex) }
            )
            GenderOptionItem(
                text = Gender.OTHER.sex,
                isSelected = state.selectedGender == Gender.OTHER.sex,
                isCustomChoice = true,
                onClick = { viewModel.onGenderSelected(Gender.OTHER.sex) }
            )
        }
        ButtonWithText(
            onClick = onContinueClick,
            text = stringResource(R.string.continue_),
            modifier = Modifier.height(56.dp)
        )
    }
}

@Composable
fun GenderOptionItem(
    text: String,
    isSelected: Boolean,
    isCustomChoice: Boolean,
    onClick: () -> Unit
) {
    val activeBorderColor = if (isSelected && !isCustomChoice) primaryContainerLight else Color.LightGray
    val backgroundBoxColor = if (isSelected && !isCustomChoice) primaryContainerLight else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundBoxColor)
            .border(
                width = if (isSelected && !isCustomChoice) 0.dp else 1.dp,
                color = activeBorderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = if (isSelected && !isCustomChoice) Color.White else MaterialTheme.colorScheme.onBackground
            )

            if (isCustomChoice) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            } else if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
            else{
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(6.dp))
}

@Composable
@Preview(showBackground = true)
fun SexScreenPreview(){
    SexScreen(
        onBackClick = {},
        onSkipClick = {},
        onContinueClick = {}
    )
}