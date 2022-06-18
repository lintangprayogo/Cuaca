package com.example.cuaca.data.source.local

import com.example.cuaca.data.source.remote.network.response.WeatherResponse
import com.example.cuaca.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {

    fun getWeathers(currentDateTime: Long, regionId: Long): Flow<WeatherModel?>

    suspend fun saveRemote(regionId: Long,list: List<WeatherResponse>)
}