package com.example.cuaca.data.source.repo

import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import com.example.cuaca.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface DetailRepo {
    fun getWeathers(
        regionId: Long,
        currentDateTime: Long
    ):  Flow<ResultResource<WeatherModel?>>

   suspend fun saveRegion(regionModel: RegionModel)

}