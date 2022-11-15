package com.lalosapps.amphibiansapp.data.repository

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>?
}