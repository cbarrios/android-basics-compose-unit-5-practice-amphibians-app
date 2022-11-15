package com.lalosapps.amphibiansapp.data.repository

import com.lalosapps.amphibiansapp.data.network.api.AmphibiansApi
import com.lalosapps.amphibiansapp.data.network.dto.Amphibian

class DefaultAmphibiansRepository(
    private val amphibiansApi: AmphibiansApi
) : AmphibiansRepository {

    override suspend fun getAmphibians(): List<Amphibian>? {
        return try {
            amphibiansApi.getAmphibians().body()
        } catch (e: Throwable) {
            null
        }
    }
}