package com.example.cuaca.data.source.local

import com.example.cuaca.data.source.remote.network.response.RegionResponse
import com.example.cuaca.data.source.remote.network.response.asListEntity
import com.example.cuaca.model.RegionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegionLocalDataSourceImp @Inject constructor(val appDatabase: AppDatabase) :
    RegionLocalDataSource {

    override fun getRegions(): Flow<List<RegionModel>> =
        appDatabase.regionDao().getRegions().map {
            it.asListModel()
        }

    override suspend fun saveRemote(list: List<RegionResponse>) =
        appDatabase.regionDao().saveRegions(list.asListEntity())

}