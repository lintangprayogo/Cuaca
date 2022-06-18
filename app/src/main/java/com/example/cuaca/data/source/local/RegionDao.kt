package com.example.cuaca.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface RegionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRegions(regionEntities: List<RegionEntity>)

    @Query("SELECT * FROM region")
    fun getRegions(): Flow<List<RegionEntity>>


}