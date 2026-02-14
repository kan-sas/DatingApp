package com.ubersoftink.datingapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight

@Composable
fun ButtonWithText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
){
    Button(
        onClick = { onClick },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(primaryContainerLight),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
    }
}