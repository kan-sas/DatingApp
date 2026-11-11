import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.components.CalendarGrid
import com.ubersoftink.datingapp.ui.components.MonthSwitch
import com.ubersoftink.datingapp.ui.theme.AppTypography
import com.ubersoftink.datingapp.ui.theme.primaryContainerLight
import java.time.LocalDate
import kotlin.collections.listOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onDaySelected: (Int) -> Unit,
    year: Int,
    selectedDay: Int?,
    month: Int,
    days: List<Int>,
    onSave: () -> Unit,
    content: @Composable () -> Unit,
){
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent ={
            CalendarContent(
                year = year,
                selectedDay = selectedDay,
                month = month,
                days = days,
                onDaySelected = onDaySelected,
                onPrevious = onPrevious,
                onNext = onNext,
                onSave = onSave
            )
        }
    ) {
        content()
    }
}


@SuppressLint("SimpleDateFormat")
@Composable
fun CalendarContent(
    modifier: Modifier = Modifier,
    year: Int,
    selectedDay: Int?,
    month: Int,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    days: List<Int>,
    onDaySelected: (Int) -> Unit,
    onSave: () -> Unit,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 56.dp, bottom = 32.dp)
    ) {
        Text(
            text = stringResource(R.string.birthday),
            style = AppTypography.bodyMedium
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            MonthSwitch(
                icon = Icons.Filled.KeyboardArrowLeft,
                onClick = onPrevious,
                contentDescription = stringResource(R.string.previous_month)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val calendar = Calendar.getInstance().apply {
                    set(Calendar.MONTH, month - 1)
                }
                val formatter = SimpleDateFormat("MMMM", Locale.US)
                Text(
                    text = year.toString(),
                    style = AppTypography.displaySmall,
                    color = primaryContainerLight,
                )
                Text(
                    text = formatter.format(calendar.time),
                    color = primaryContainerLight,
                )
            }
            MonthSwitch(
                icon = Icons.Filled.KeyboardArrowRight,
                onClick = onNext,
                contentDescription = stringResource(R.string.next_month),
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            CalendarGrid(
                modifier = Modifier.fillMaxWidth(),
                items = days,
                sizeOfRow = 7
            ) { day ->
                val isSelected = day == selectedDay

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color(0xFFEF445B) else Color.Transparent)
                        .clickable { onDaySelected(day) }
                ) {
                    Text(
                        text = day.toString(),
                        color = if (isSelected) Color.White else Color.Black,
                        fontSize = 16.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }

            }
            Spacer(Modifier.padding(vertical = 20.dp))
            SaveBirthDate(
                onClick = onSave,
                text = stringResource(R.string.save),
            )
        }
    }
}

@Composable
fun SaveBirthDate(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
){
    Button(
        onClick = onClick,
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

@Preview(showBackground = true)
@Composable
fun CalendarContentPreview(){
    CalendarContent(
        year = 1995,
        month = 7,
        days = listOf(
            1, 2, 3, 4, 5, 6, 7,
            8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28,
            29, 30, 31
        ),
        selectedDay = 11,
        onDaySelected = {},
        onNext = {},
        onPrevious = {},
        onSave = {}
    )
}