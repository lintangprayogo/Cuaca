package com.example.cuaca.data.source.local

import com.example.cuaca.model.RegionModel
import kotlinx.coroutines.flow.Flow

interface MyRegionDataSource {
    fun getRegions(): Flow<List<RegionModel>>
    suspend fun save(regionModel: RegionModel)
    suspend fun delete(regionModel: RegionModel)
}