package com.lalosapps.amphibiansapp.fake.viewmodel

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian
import com.lalosapps.amphibiansapp.data.repository.AmphibiansRepository
import com.lalosapps.amphibiansapp.fake.repository.FakeDataSource

class FakeAmphibiansRepository : AmphibiansRepository {

    var returnsNull = false

    override suspend fun getAmphibians(): List<Amphibian>? {
        if (returnsNull) return null
        return FakeDataSource.amphibians
    }
}