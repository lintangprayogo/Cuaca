package com.example.cuaca.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cuaca.model.WeatherModel

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Long? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date_time")
    val dateTime: Long,
    @ColumnInfo(name = "code")
    val code: Int,
    @ColumnInfo(name = "humidity")
    val humidity: Long,
    @ColumnInfo(name = "temp_c")
    val tempC: Long,
    @ColumnInfo(name = "temp_f")
    val tempF: Long,
    @ColumnInfo(name = "region_id")
    val regionId: Long
)


fun WeatherEntity.asModel()= WeatherModel(
    id = id,
    code = code,
    dateTime = dateTime,
    humidity = humidity,
    name = name,
    regionId = regionId,
    tempC = tempC,
    tempF = tempF
)
