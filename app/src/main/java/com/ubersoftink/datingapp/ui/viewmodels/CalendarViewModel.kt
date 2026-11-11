package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.YearMonth

class CalendarViewModel: ViewModel() {
    private val _state = MutableStateFlow(CalendarUiState())
    val state = _state.asStateFlow()

    init {
        val amountOfDays = YearMonth.of(LocalDate.now().year, LocalDate.now().month).lengthOfMonth()
        _state.update {
            it.copy(
                year = LocalDate.now().year - 18,
                month = LocalDate.now().month.value,
                days = (1..amountOfDays).toList()
            )
        }
        LocalDate.now()
    }

    fun updateSelectedDay(newDay: Int){
        _state.update { it.copy(
            selectedDay = newDay
        ) }
    }

    fun changeMonth(delta: Int) {
        _state.update { currentState ->
            var newMonth = currentState.month + delta
            var newYear = currentState.year

            if (newMonth > 12) {
                newMonth = 1
                newYear++
            } else if (newMonth < 1) {
                newMonth = 12
                newYear--
            }
            val days = getDaysInMonthLegacy(newYear, newMonth)

            currentState.copy(month = newMonth, year = newYear, days = days)
        }
    }

    private fun getDaysInMonthLegacy(year: Int, month: Int): List<Int> {
        val amountOfDays = YearMonth.of(year, month).lengthOfMonth()
        return (1..amountOfDays).toList()
    }
}
