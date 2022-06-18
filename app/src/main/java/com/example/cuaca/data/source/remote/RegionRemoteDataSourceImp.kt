package com.example.cuaca.data.source.remote

import com.example.cuaca.data.source.remote.network.ApiService
import com.example.cuaca.data.source.remote.network.response.RegionResponse
import javax.inject.Inject

class RegionRemoteDataSourceImp @Inject constructor(private val apiService: ApiService) :
    RegionRemoteDataSource {

    override suspend fun getRegions(): List<RegionResponse> = apiService.getRegions()

}