package com.example.cuaca.data.source.remote

import com.example.cuaca.data.source.remote.network.response.WeatherResponse

interface WeatherRemoteDataSource {
    suspend fun getWeathers(regionId:Long): List<WeatherResponse>
}