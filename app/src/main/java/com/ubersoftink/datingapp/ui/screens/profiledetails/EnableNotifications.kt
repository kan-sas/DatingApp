package com.ubersoftink.datingapp.ui.screens.profiledetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.components.ButtonWithText
import com.ubersoftink.datingapp.ui.components.ClickableText
import com.ubersoftink.datingapp.ui.theme.AppTypography

@Composable
fun NotificationsScreen(
    onSkipClick: () -> Unit = {},
    onNotifyClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ClickableText(
                onClick = onSkipClick,
                text = stringResource(R.string.skip),
                style = AppTypography.titleLarge,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
           Image(
                painter = painterResource(R.drawable._467480590740298479),
                contentDescription = stringResource(R.string.notification_icon),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = stringResource(R.string.enable_notification_s),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.get_push_notification_when_you_get_the_match_or_receive_a_message),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        ButtonWithText(
            onClick = onNotifyClick,
            text = stringResource(R.string.i_want_to_be_notified),
            modifier = Modifier.height(56.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NotificationPreview(){
    NotificationsScreen()
}