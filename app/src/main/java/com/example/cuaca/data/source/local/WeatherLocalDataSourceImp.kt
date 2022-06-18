package com.example.cuaca.data.source.local

import com.example.cuaca.data.source.remote.network.response.WeatherResponse
import com.example.cuaca.data.source.remote.network.response.asListEntity
import com.example.cuaca.model.WeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherLocalDataSourceImp @Inject constructor(val appDatabase: AppDatabase) :
    WeatherLocalDataSource {

    override fun getWeathers(currentDateTime: Long, regionId: Long): Flow<WeatherModel?> {
        return appDatabase.weatherDao().getCurrentWeather(
            currentDateTime = currentDateTime,
            currentRegionId = regionId
        ).map {
            it?.asModel()
        }
    }

    override suspend fun saveRemote(regionId: Long, list: List<WeatherResponse>) {
        appDatabase.weatherDao().saveWeathers(list.asListEntity(regionId))
    }


}