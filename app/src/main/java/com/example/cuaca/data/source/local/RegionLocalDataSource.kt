package com.example.cuaca.data.source.local

import com.example.cuaca.data.source.remote.network.response.RegionResponse
import com.example.cuaca.model.RegionModel
import kotlinx.coroutines.flow.Flow

interface RegionLocalDataSource {
    fun getRegions(): Flow<List<RegionModel>>
    suspend fun saveRemote(list: List<RegionResponse>)
}