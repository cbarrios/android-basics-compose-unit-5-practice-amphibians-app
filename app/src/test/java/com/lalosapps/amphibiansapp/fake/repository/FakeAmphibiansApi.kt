package com.lalosapps.amphibiansapp.fake.repository

import com.lalosapps.amphibiansapp.data.network.api.AmphibiansApi
import com.lalosapps.amphibiansapp.data.network.dto.Amphibian
import okhttp3.internal.EMPTY_RESPONSE
import retrofit2.Response

class FakeAmphibiansApi : AmphibiansApi {

    var errorResponse = false
    var throwsException = false

    override suspend fun getAmphibians(): Response<List<Amphibian>> {
        if (throwsException) throw Exception("Something went wrong.")
        if (errorResponse) {
            return Response.error(500, EMPTY_RESPONSE)
        }
        return Response.success(200, FakeDataSource.amphibians)
    }
}