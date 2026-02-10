package com.ubersoftink.datingapp.ui.screens.code

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark

@Composable
fun CodeVerificationScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
){
    Column(
        modifier = modifier
            .padding(40.dp)
            .fillMaxSize()
    ) {
        OutlinedIconButton(
            onClick = navigateUp,
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.size(55.dp),
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
                .padding(top = 50.dp)
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
                    .padding(horizontal = 50.dp),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
            UserCodeInput()
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
    CodeVerificationScreen(
        navigateUp = {}
    )
}