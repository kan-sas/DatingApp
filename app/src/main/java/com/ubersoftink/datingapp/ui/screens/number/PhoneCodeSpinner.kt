package com.ubersoftink.datingapp.ui.screens.number

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.ubersoftink.datingapp.data.PhoneCode

class SpinnerAdapter(val onSpinnerChange: (Int) -> Unit): AdapterView.OnItemSelectedListener {
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        onSpinnerChange(position)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        onSpinnerChange(0)
    }
}

@Composable
fun PhoneCodeSpinner(
    modifier: Modifier = Modifier,
    codeSpinnerPosition: Int,
    onSpinnerChange: (Int) -> Unit,
) {
    val numberCodeArray = PhoneCode.values().map { numberCode ->
        stringResource(numberCode.countryFlag) + "(+${numberCode.code})"
    }
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            Spinner(context).apply {
                adapter = ArrayAdapter(
                    context,
                    android.R.layout.simple_spinner_dropdown_item,
                    numberCodeArray
                )
            }
        },
        update = { spinner ->
            spinner.setSelection(codeSpinnerPosition)
            spinner.onItemSelectedListener = SpinnerAdapter(onSpinnerChange)
        }
    )
}