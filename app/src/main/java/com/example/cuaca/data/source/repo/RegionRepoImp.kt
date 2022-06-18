package com.example.cuaca.data.source.repo

import com.example.cuaca.data.source.NetworkBoundResource
import com.example.cuaca.data.source.local.MyRegionDataSource
import com.example.cuaca.data.source.local.RegionLocalDataSource
import com.example.cuaca.data.source.remote.RegionRemoteDataSource
import com.example.cuaca.data.source.remote.network.response.RegionResponse
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegionRepoImp @Inject constructor(
    private val remoteDataSource: RegionRemoteDataSource,
    private val localDataSource: RegionLocalDataSource,
    private val myRegionDataSource: MyRegionDataSource
) : RegionRepo {

    override fun getRegions() =
        object : NetworkBoundResource<List<RegionModel>, List<RegionResponse>>() {
            override fun shouldFetch(data: List<RegionModel>): Boolean {
                return data.isEmpty()
            }

            override suspend fun saveRemoteData(response: List<RegionResponse>) {
                localDataSource.saveRemote(response)
            }

            override fun fetchFromLocal(): Flow<List<RegionModel>> {
                return localDataSource.getRegions().map { list ->
                    list.filter { it.city != "a:0:{}" }
                }
            }

            override suspend fun fetchFromRemote(): ResultResource<List<RegionResponse>> =
                try {
                    ResultResource.Success(remoteDataSource.getRegions())
                } catch (throwable: Throwable) {
                    ResultResource.Error(throwable = throwable)
                }
        }.asFlow()

    override fun getMyRegions(): Flow<List<RegionModel>> = myRegionDataSource.getRegions()

    override suspend fun deleteMyRegion(regionModel: RegionModel) = myRegionDataSource.delete(regionModel)



}