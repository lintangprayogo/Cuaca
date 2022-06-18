package com.example.cuaca.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cuaca.model.RegionModel

@Entity(tableName = "region")
data class RegionEntity(
    @PrimaryKey
    @ColumnInfo(name = "_id")
    val id: Long,
    @ColumnInfo(name = "province")
    val province: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "district")
    val district: String
)

fun List<RegionEntity>.asListModel() = this.map {
    it.asModel()
}


private fun RegionEntity.asModel() = RegionModel(
    id,
    province,
    city,
    district
)