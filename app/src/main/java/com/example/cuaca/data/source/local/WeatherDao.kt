package com.example.cuaca.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Transaction
    suspend fun saveWeathers(weatherEntities: List<WeatherEntity>) {
        if (weatherEntities.isNotEmpty()) {
            clearWeathers(weatherEntities[0].regionId)
        }
        insertWeathers(weatherEntities)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeathers(weatherEntities: List<WeatherEntity>)

    @Query(
        """
        SELECT * FROM weather 
        WHERE date_time <:currentDateTime AND region_id =:currentRegionId
        ORDER BY date_time desc
        """
    )
    fun getCurrentWeather(currentDateTime: Long, currentRegionId: Long): Flow<WeatherEntity?>

    @Query("DELETE FROM weather where region_id=:regionId")
    suspend fun clearWeathers(regionId: Long)
}