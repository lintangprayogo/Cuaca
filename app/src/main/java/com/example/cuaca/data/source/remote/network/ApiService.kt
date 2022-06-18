package com.example.cuaca.data.source.remote.network

import com.example.cuaca.data.source.remote.network.response.RegionResponse
import com.example.cuaca.data.source.remote.network.response.WeatherResponse
import com.example.cuaca.di.Constant.REGION_PATH
import com.example.cuaca.di.Constant.WEATHER_PATH
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET(WEATHER_PATH)
    suspend fun getWeather(@Path(REGION_PATH) regionId: Long): List<WeatherResponse>

    @GET("cuaca/wilayah.json")
    suspend fun getRegions(): List<RegionResponse>

}