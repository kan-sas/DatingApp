package com.ubersoftink.datingapp.ui.screens.code

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.components.NumberButton
import com.ubersoftink.datingapp.ui.components.NumberButtonRow

@Composable
fun OtpKeyboard(
    modifier: Modifier = Modifier,
    onClick: (Char) -> Unit,
    onDeletePressed: () -> Unit,
){
    Column(modifier = Modifier.padding(horizontal = 28.dp)){
        NumberButtonRow(
            sizeOfRow = 3,
            numberOfRows = 3,
            numbers = listOf(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
            ),
            onClick = onClick
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(2f))
            NumberButton(
                number = 0,
                onClick = onClick,
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = onDeletePressed,
                Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.backspace),
                    contentDescription = stringResource(R.string.delete_symbol),
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}