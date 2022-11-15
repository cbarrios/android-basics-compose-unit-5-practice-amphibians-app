package com.lalosapps.amphibiansapp.di

import com.lalosapps.amphibiansapp.data.network.api.AmphibiansApi
import com.lalosapps.amphibiansapp.data.repository.AmphibiansRepository

interface AppContainer {
    val amphibiansApi: AmphibiansApi
    val amphibiansRepository: AmphibiansRepository
}