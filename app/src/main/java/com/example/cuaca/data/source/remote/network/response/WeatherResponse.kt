package com.example.cuaca.data.source.remote.network.response

import com.example.cuaca.data.source.local.WeatherEntity
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class WeatherResponse(
    @SerializedName("cuaca")
    val name: String,
    @SerializedName("jamCuaca")
    val dateTime: String,
    @SerializedName("kodeCuaca")
    val code: Int,
    val humidity: Long,
    val tempC: Long,
    val tempF: Long
)


fun  List<WeatherResponse>.asListEntity(regionId: Long)=this.map {
    it.asEntity(regionId)
}

private fun WeatherResponse.asEntity(regionId:Long)=WeatherEntity(
    name=name,
    dateTime = dateTime.asLocalDateTime(),
    code = code,
    humidity=humidity,
    tempC=tempC,
    tempF=tempF,
    regionId =regionId
)

fun String.asLocalDateTime(): Long {
    return SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss", Locale.getDefault()
    ).parse(this)?.time ?: 0L
}