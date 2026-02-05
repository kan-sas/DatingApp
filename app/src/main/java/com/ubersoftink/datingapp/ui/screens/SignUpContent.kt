package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark
import com.ubersoftink.datingapp.ui.theme.primaryContainerLightMediumContrast

@Composable
fun SignUpContent(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = stringResource(R.string.app_logo_desc),
            modifier.size(200.dp)
        )
        Text(
            text = stringResource(R.string.sign_up_to_continue),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            //fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = modifier.padding(20.dp)
        )
        Button(
            onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(primaryContainerDark)
        ) {
            Text(
                text = stringResource(R.string.continue_with_email),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(12.dp)
            )
        }
        OutlinedButton(
            onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 80.dp),
            shape = RoundedCornerShape(16.dp),
        ){
            Text(
                text = stringResource(R.string.use_phone_number),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(12.dp),
                color = primaryContainerDark,
            )
        }
        Row(
            modifier = modifier.padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier.weight(1f))
            Text(
                text = stringResource(R.string.or_sign_up_with),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = modifier.padding(horizontal = 8.dp)
            )
            Divider(modifier.weight(1f))
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedContentButton(
                onClick = {},
                imageIcon = Icons.Filled.ThumbUp,
                contentDesc = ""
            )
            OutlinedContentButton(
                onClick = {},
                imageIcon = Icons.Filled.Star,
                contentDesc = ""
            )
            OutlinedContentButton(
                onClick = {},
                imageIcon = Icons.Filled.Call,
                contentDesc = ""
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = stringResource(R.string.terms_of_use),
                color = primaryContainerLightMediumContrast,
                )
            Text(
                text = stringResource(R.string.privacy_policy),
                color = primaryContainerLightMediumContrast,
                )
        }
    }
}

@Composable
fun OutlinedContentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageIcon: ImageVector,
    contentDesc: String,
){
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
    ) {
        Icon(
            imageVector = imageIcon,
            contentDescription = contentDesc,
            tint = primaryContainerDark,
            modifier = modifier.padding(vertical = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview(){
    SignUpContent()
}