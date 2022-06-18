package com.example.cuaca.data.source.remote

import com.example.cuaca.data.source.remote.network.response.RegionResponse

interface RegionRemoteDataSource {
    suspend fun getRegions(): List<RegionResponse>
}