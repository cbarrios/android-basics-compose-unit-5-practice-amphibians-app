package com.lalosapps.amphibiansapp.data.network.api

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian
import retrofit2.Response
import retrofit2.http.GET

interface AmphibiansApi {

    companion object {
        const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
    }

    @GET("amphibians")
    suspend fun getAmphibians(): Response<List<Amphibian>>
}