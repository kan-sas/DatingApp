package com.ubersoftink.datingapp.ui.screens.number

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark

@Composable
fun NumberScreen(
    modifier: Modifier = Modifier,
    onContinueButton: () -> Unit,
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp)
            .padding(vertical = 110.dp)
    ) {
        Text(
            text = stringResource(R.string.my_mobile),
            fontWeight = FontWeight.Bold,
            style = AppTypography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = stringResource(R.string.please_enter_your_valid_phone_number),
            style = AppTypography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = modifier.padding(vertical = 8.dp)
        )
        Card(
            modifier = modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                PhoneCodeSpinner(
                    modifier = modifier.weight(1f),
                    codeSpinnerPosition = 0,
                    onSpinnerChange = {}
                )
                VerticalDivider(
                    modifier = modifier.height(24.dp),
                    color = Color.LightGray
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    singleLine = true,
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.surface),
                    modifier = modifier.weight(1.3f)
                )
            }
        }
        Button(
            onClick = { onContinueButton },
            modifier = modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(primaryContainerDark),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = stringResource(R.string.continue_),
                fontWeight = FontWeight.Bold,
                style = AppTypography.titleMedium,
                modifier = modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumberScreenPreview(){
    NumberScreen(onContinueButton = {})
}