package com.ubersoftink.datingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ubersoftink.datingapp.ui.navigation.AppNavGraph
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val catViewModel: CatsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavGraph(catViewModel = catViewModel)
        }
    }
}