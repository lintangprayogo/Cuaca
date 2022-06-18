package com.example.cuaca.model

import com.example.cuaca.R

data class WeatherModel(
    val id: Long?,
    val name: String,
    val dateTime: Long,
    val code: Int,
    val humidity: Long,
    val tempC: Long,
    val tempF: Long,
    val regionId: Long
)

fun Int.asWeatherAnimId() = when (this) {
    0 -> R.raw.anim_clear
    1 -> R.raw.anim_partly_cloudy
    2 -> R.raw.anim_partly_cloudy
    3 -> R.raw.anim_mostly_cloudy
    4 -> R.raw.anim_overcast
    5 -> R.raw.anim_haze_smoke
    6 -> R.raw.anim_haze_smoke
    45 -> R.raw.anim_fog
    60 -> R.raw.anim_rainy
    61 -> R.raw.anim_rainy
    63 -> R.raw.anim_rainy
    80 -> R.raw.anim_isolated_shower
    95 -> R.raw.anim_thunderstorms
    97 -> R.raw.anim_thunderstorms
    else -> R.raw.anim_clear
}