package com.ubersoftink.datingapp.data

import androidx.annotation.StringRes
import com.ubersoftink.datingapp.R

enum class PhoneCode(@StringRes val countryFlag: Int, val code: Int) {
    Belarus(R.string.belarus_flag, 375),
    America(R.string.america_flag, 1),
    Canada(R.string.canada_flag,1),
    Ukraine(R.string.ukraine_flag, 380),
    Georgia(R.string.georgia_flag,995),
    China(R.string.china_flag, 86),
    Poland(R.string.poland_flag, 48),
    Czechia(R.string.czechia_flag, 420),
    Russia(R.string.russia_flag, 7)
}