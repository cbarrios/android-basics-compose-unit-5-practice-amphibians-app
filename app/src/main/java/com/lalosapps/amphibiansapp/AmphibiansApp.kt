package com.lalosapps.amphibiansapp

import android.app.Application
import com.lalosapps.amphibiansapp.di.AppContainer
import com.lalosapps.amphibiansapp.di.DefaultAppContainer

class AmphibiansApp : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }

}