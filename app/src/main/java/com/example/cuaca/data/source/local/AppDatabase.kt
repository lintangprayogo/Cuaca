package com.example.cuaca.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [
        RegionEntity::class,
        WeatherEntity::class,
        MyRegionEntity::class
    ],
    version = 4
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun regionDao(): RegionDao
    abstract fun weatherDao(): WeatherDao
    abstract fun myRegionDao(): MyRegionDao
}
