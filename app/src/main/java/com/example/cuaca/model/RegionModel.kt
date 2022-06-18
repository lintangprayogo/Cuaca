package com.example.cuaca.model

import com.example.cuaca.data.source.local.MyRegionEntity


data class RegionModel(
    val id: Long,
    val province: String,
    val city: String,
    val district: String
)

fun RegionModel.asMyRegionEntity() = MyRegionEntity(
    id,
    province,
    city,
    district
)
