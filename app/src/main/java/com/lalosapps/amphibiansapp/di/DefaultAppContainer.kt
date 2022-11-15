package com.lalosapps.amphibiansapp.di

import com.lalosapps.amphibiansapp.data.network.api.AmphibiansApi
import com.lalosapps.amphibiansapp.data.repository.AmphibiansRepository
import com.lalosapps.amphibiansapp.data.repository.DefaultAmphibiansRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DefaultAppContainer : AppContainer {

    override val amphibiansApi: AmphibiansApi by lazy {
        Retrofit.Builder()
            .baseUrl(AmphibiansApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    override val amphibiansRepository: AmphibiansRepository by lazy {
        DefaultAmphibiansRepository(amphibiansApi)
    }
}