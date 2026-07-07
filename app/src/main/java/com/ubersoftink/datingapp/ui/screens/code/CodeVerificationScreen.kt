package com.ubersoftink.datingapp.ui.screens.code

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark
import com.ubersoftink.datingapp.ui.viewmodels.OtpAction
import com.ubersoftink.datingapp.ui.viewmodels.OtpViewModel

@Composable
fun CodeVerificationScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    viewModel: OtpViewModel = hiltViewModel<OtpViewModel>(),
    verificationId: String?
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    val focusRequesters = remember {
        (1..6).map { FocusRequester() }
    }

    LaunchedEffect(verificationId) {
        if (verificationId != null) {
            viewModel.updateVerificationId(verificationId)
        } else {
            Log.e("CodeVerification", "Verification ID is null")
        }
    }

    LaunchedEffect(state.focusedIndex) {
        state.focusedIndex?.let { index ->
            focusRequesters.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(state.code) {
        val allNumberEntered = state.code.none{ it == null}
        if(allNumberEntered){
            focusRequesters.forEach{
                it.freeFocus()
            }
        }
    }

    Column(
        modifier = modifier
            .padding(vertical = 28.dp)
            .fillMaxSize()
    ) {
        OutlinedIconButton(
            onClick = navigateUp,
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .padding(horizontal = 28.dp)
                .padding(top = 16.dp)
                .size(55.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = stringResource(R.string.back_to_phone_number_screen),
                tint = primaryContainerDark,
                modifier = modifier.size(32.dp)
            )
        }
        Column(
            modifier = modifier
                .padding(top = 28.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "00:42",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.type_the_verification_code_we_ve_send_you),
                modifier = modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 80.dp),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(
                modifier = Modifier
                    .padding(24.dp)
            )
            OtpInputField(
                state = state,
                focusRequesters = focusRequesters,
                onAction = { action ->
                    when(action){
                        is OtpAction.OnEnterNumber -> {
                            if(action.number != null){
                                focusRequesters[action.index].freeFocus()
                            }
                        }
                        else -> Unit
                    }
                    viewModel.onAction(action)
                },
            )
            when (state.isValid) {
                true -> {
                    Text(
                        text = "OTP is valid!",
                        color = Color.Green,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                false -> {
                    Text(
                        text = "Invalid OTP. Please try again.",
                        color = Color.Red,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                else -> null
            }
            Spacer(modifier = Modifier.padding(40.dp))
            OtpKeyboard(
                onClick = {number ->
                    val targetIndex = state.focusedIndex ?: 0
                    viewModel.onAction(
                        OtpAction.OnEnterNumber(
                            number = number.toString().toIntOrNull(),
                            index = targetIndex
                        )
                    )
                },
                onDeletePressed = {
                    viewModel.onAction(OtpAction.OnKeyBoardBack)
                }
            )
            Spacer(Modifier.padding(16.dp))
            Card(
                onClick = {},
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = stringResource(R.string.send_again),
                    fontWeight = FontWeight.Bold,
                    color = primaryContainerDark,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CodeVerificationPreview(){
    CodeVerificationScreen(navigateUp = {}, verificationId = "")
}