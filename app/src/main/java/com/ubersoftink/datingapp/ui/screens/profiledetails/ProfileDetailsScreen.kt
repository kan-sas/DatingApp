package com.ubersoftink.datingapp.ui.screens.profiledetails

import Calendar
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.components.ButtonWithText
import com.ubersoftink.datingapp.ui.components.ClickableText
import com.ubersoftink.datingapp.ui.components.ProfileTextField
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerDark
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight
import com.ubersoftink.datingapp.ui.theme.surfaceVariantLight
import com.ubersoftink.datingapp.ui.viewmodels.CalendarViewModel
import com.ubersoftink.datingapp.ui.viewmodels.RegistrationViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailsScreen(
    modifier: Modifier = Modifier,
    onSkipClick: () -> Unit,
    toSexScreen: () -> Unit,
    calendarViewModel: CalendarViewModel = hiltViewModel(),
    regViewModel: RegistrationViewModel = hiltViewModel(),
){
    val scope = rememberCoroutineScope()
    val calendarState by calendarViewModel.state.collectAsState()
    val regState by regViewModel.state.collectAsState()

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false,
        )
    )
    
    val hideBottomScaffold = {
        scope.launch { bottomSheetScaffoldState.bottomSheetState.partialExpand() }
    }

    val expandBottomScaffold = {
        scope.launch { bottomSheetScaffoldState.bottomSheetState.expand() }
    }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        regViewModel.onProfilePictureSelected(uri)
    }

    Calendar(
        scaffoldState = bottomSheetScaffoldState,
        onNext = { calendarViewModel.changeMonth(+1) },
        onPrevious = { calendarViewModel.changeMonth(-1) },
        month = calendarState.month,
        year = calendarState.year,
        days = calendarState.days,
        selectedDay = calendarState.selectedDay,
        onDaySelected = { it ->
            calendarViewModel.updateSelectedDay(it)
        },
        onSave = {
            regViewModel.saveBirthDate(LocalDate.of(
                calendarState.year,
                calendarState.month,
                calendarState.selectedDay?.toInt() ?: 1
            ))
            hideBottomScaffold()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ClickableText(
                onClick = onSkipClick,
                modifier = Modifier
                    .padding(top = 56.dp, end = 41.dp)
                    .align(Alignment.End),
                text = stringResource(R.string.skip),
                style = AppTypography.titleLarge
            )
            Text(
                text = stringResource(R.string.profile_details),
                style = AppTypography.displaySmall,
                modifier = Modifier
                    .padding(start = 40.dp, top = 40.dp)
            )
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(16.dp))
                Box(
                    modifier = Modifier
                        .clickable(onClick = {
                            imagePickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        })
                ) {
                    if (regState.profilePicture.isNullOrEmpty()) {
                        Image(
                            painter = painterResource(R.drawable.default_icon_profile_picture),
                            contentDescription = stringResource(R.string.default_profile_picture),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(100.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        AsyncImage(
                            model = regState.profilePicture,
                            contentDescription = stringResource(R.string.default_profile_picture),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(100.dp)
                                .clip(CircleShape)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(top = 80.dp, start = 80.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp, vertical = 8.dp)
                                .clip(CircleShape)
                                .background(primaryContainerDark)
                                .size(50.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.camera_icon),
                            contentDescription = stringResource(R.string.change_profile_photo),
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier
                                .size(60.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(12.dp))
                ProfileTextField(
                    profileTextLabel = stringResource(R.string.first_name),
                    onTextChanged = { regViewModel.firstNameChanged(it) },
                    text = regState.name,
                )
                ProfileTextField(
                    profileTextLabel = stringResource(R.string.last_name),
                    onTextChanged = {regViewModel.lastNameChanged(it)},
                    text = regState.lastName,
                )
                Button(
                    onClick = { expandBottomScaffold() },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(surfaceVariantLight)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = stringResource(R.string.calendar_icon),
                            modifier = Modifier
                                .size(32.dp),
                            tint = primaryContainerLight
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        Text(
                            text = stringResource(R.string.chose_birthday_date),
                            style = AppTypography.titleMedium,
                            color = primaryContainerLight,
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(48.dp))
                ButtonWithText(
                    onClick = { toSexScreen() },
                    text = stringResource(R.string.confirm)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileDetailsPreview(){
    ProfileDetailsScreen(
        onSkipClick = {},
        toSexScreen = {},
    )
}