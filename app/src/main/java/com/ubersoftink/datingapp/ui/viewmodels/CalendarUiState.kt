package com.ubersoftink.datingapp.ui.viewmodels

import java.time.Month

data class CalendarUiState(
    val year: Int = 1995,
    val month: Int = 7,
    val selectedDay: Int? = null,
    val days: List<Int> = listOf(
        1, 2, 3, 4, 5, 6, 7,
        8, 9, 10, 11, 12, 13, 14,
        15, 16, 17, 18, 19, 20, 21,
        22, 23, 24, 25, 26, 27, 28,
        29, 30, 31
    ),
)
