package com.ubersoftink.datingapp.ui.screens.code

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.ui.theme.AppTypography

@Composable
fun UserCodeInput(
    modifier: Modifier = Modifier,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NumberButtonRow(
            sizeOfRow = 3,
            numberOfRows = 3,
            numbers = listOf(1,2,3,4,5,6,7,8,9),
            onClick = {}
        )
        NumberButton(
            number = 0,
            onClick = {}
        )
    }
}

@Composable
fun CodeForm(){
    Row {  }
}

@Composable
fun NumberInput(){
    OutlinedButton(
        onClick = {}
    ) { }
}


//Вынести в Buttons.kt
@Composable
private fun NumberButtonRow(
    numberOfRows: Int,
    sizeOfRow: Int,
    numbers: List<Int>,
    onClick: (Char) -> Unit,
){
    Column(
        modifier = Modifier
    ) {
        var i = 0
        while (i < numberOfRows) {
            var j = 0
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                while (j < sizeOfRow) {
                    NumberButton(
                        number = numbers[j + sizeOfRow * i],
                        onClick = onClick,
                        modifier = Modifier.weight(1f)
                    )
                    j++
                }
            }
            i++
        }
    }
}

//Вынести в Buttons.kt
@Composable
fun NumberButton(
    number: Int,
    onClick: (Char) -> Unit,
    modifier: Modifier = Modifier,
){
    OutlinedButton(
        onClick = {
            onClick(number.digitToChar())
        },
        modifier = modifier
            .padding(4.dp),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = SolidColor(MaterialTheme.colorScheme.background)
        )
    ) {
        Text(
            text = number.toString(),
            style = AppTypography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun UserCodeInputPreview(){
    UserCodeInput()
}