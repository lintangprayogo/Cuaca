package com.example.cuaca.data.source.local

import com.example.cuaca.model.RegionModel
import com.example.cuaca.model.asMyRegionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MyRegionDataSourceImp @Inject constructor(val appDatabase: AppDatabase) :
    MyRegionDataSource {

    override fun getRegions(): Flow<List<RegionModel>> =
        appDatabase.myRegionDao().getRegions().map {
            it.asListModel()
        }

    override suspend fun save(regionModel: RegionModel) =
        appDatabase.myRegionDao().saveRegion(regionModel.asMyRegionEntity())

    override suspend fun delete(regionModel: RegionModel) {
        appDatabase.myRegionDao().deleteRegion(regionModel.asMyRegionEntity())
    }

}