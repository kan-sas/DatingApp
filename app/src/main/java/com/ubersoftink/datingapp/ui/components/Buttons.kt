package com.ubersoftink.datingapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight

@Composable
fun ClickableText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    style: TextStyle,
){
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = text,
            color = primaryContainerLight,
            style = style,
        )
    }
}

@Composable
fun ProfileTextField(
    text: String,
    profileTextLabel: String,
    onTextChanged: (String) -> Unit,
){
    Box {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            TextField(
                value = text,
                onValueChange = { onTextChanged(it) },
                singleLine = true,
                colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.surface),
            )
        }
        Box(
            modifier = Modifier
                .size(width = 114.dp, height = 24.dp)
                .padding(start = 32.dp)
                .background(MaterialTheme.colorScheme.surface)
        )
        Text(
            text = profileTextLabel,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 40.dp)
        )
    }
}

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
fun CalendarGrid(
    modifier: Modifier = Modifier,
    items: List<Int>,
    sizeOfRow: Int,
    content: @Composable (item: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(sizeOfRow),
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(items){ item ->
            content(item)
        }
    }
}
@Composable
fun NumberButtonRows(
    modifier: Modifier = Modifier,
    numberOfRows: Int,
    sizeOfRow: Int,
    numbers: List<Int>,
    onClick: (Char) -> Unit,
    style: TextStyle = AppTypography.headlineMedium
){
    Column(
        modifier = Modifier
    ) {
        var i = 0
        while (i < numberOfRows) {
            var j = 0
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                while (j < sizeOfRow) {
                    NumberButton(
                        modifier = Modifier
                        ,
                        number = numbers[j + sizeOfRow * i],
                        onClick = onClick,
                        style = style
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
    style: TextStyle = AppTypography.headlineMedium
){
    OutlinedButton(
        modifier = modifier,
        onClick = {
            onClick(number.digitToChar())
        },
        border = BorderStroke(
            color = MaterialTheme.colorScheme.background,
            width = 0.dp,
        )
    ) {
        Text(
            text = number.toString(),
            style = style,
            maxLines = 1,
            softWrap = true,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun MonthSwitch(
    icon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String,
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Icon(
            imageVector = icon,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = contentDescription
        )
    }
}