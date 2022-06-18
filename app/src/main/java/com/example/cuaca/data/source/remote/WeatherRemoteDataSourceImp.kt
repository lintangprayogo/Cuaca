package com.example.cuaca.data.source.remote

import com.example.cuaca.data.source.remote.network.ApiService
import com.example.cuaca.data.source.remote.network.response.WeatherResponse
import javax.inject.Inject

class WeatherRemoteDataSourceImp @Inject constructor(private val apiService: ApiService) :
   WeatherRemoteDataSource {

    override suspend fun getWeathers(regionId: Long): List<WeatherResponse> = apiService.getWeather(regionId)


}