package com.example.cuaca.data.source.repo

import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import kotlinx.coroutines.flow.Flow

interface RegionRepo {
    fun getRegions(): Flow<ResultResource<List<RegionModel>>>
    fun getMyRegions(): Flow<List<RegionModel>>
    suspend fun deleteMyRegion(regionModel: RegionModel)
}