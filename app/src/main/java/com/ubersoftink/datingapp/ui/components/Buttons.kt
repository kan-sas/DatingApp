package com.ubersoftink.datingapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight

@Composable
fun ButtonWithText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
){
    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(primaryContainerLight),
    ) {
        Text(
            text = text,
            style = AppTypography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun NumberButtonRow(
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
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                while (j < sizeOfRow) {
                    NumberButton(
                        number = numbers[j + sizeOfRow * i],
                        onClick = onClick,
                    )
                    j++
                }
            }
            i++
        }
    }
}

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