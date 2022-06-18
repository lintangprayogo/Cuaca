package com.example.cuaca.data.source.remote.network.response

import com.example.cuaca.data.source.local.RegionEntity
import com.google.gson.annotations.SerializedName

data class RegionResponse(
    val id: Long,
    @SerializedName("propinsi")
    val province: String,
    @SerializedName("kota")
    val city: String,
    @SerializedName("kecamatan")
    val district: String
)

fun List<RegionResponse>.asListEntity() = this.map {
    it.asEntity()
}

private fun RegionResponse.asEntity() = RegionEntity(
    id,
    province,
    city,
    district
)
