package com.ubersoftink.datingapp

import android.app.Application
import com.ubersoftink.datingapp.data.AppContainer
import com.ubersoftink.datingapp.data.NetworkContainer

class DatingApplication: Application(){
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = NetworkContainer()
    }
}