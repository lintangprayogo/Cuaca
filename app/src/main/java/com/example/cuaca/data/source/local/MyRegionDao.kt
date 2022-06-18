package com.example.cuaca.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface MyRegionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRegion(regionEntities: MyRegionEntity)

    @Query("SELECT * FROM MY_REGION")
    fun getRegions(): Flow<List<MyRegionEntity>>

    @Delete
    suspend fun deleteRegion(regionEntities: MyRegionEntity)

}