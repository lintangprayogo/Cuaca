package com.example.cuaca.data.source.repo

import com.example.cuaca.data.source.NetworkBoundResource
import com.example.cuaca.data.source.local.MyRegionDataSource
import com.example.cuaca.data.source.local.WeatherLocalDataSource
import com.example.cuaca.data.source.remote.WeatherRemoteDataSource
import com.example.cuaca.data.source.remote.network.response.WeatherResponse
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import com.example.cuaca.model.WeatherModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailRepoImp @Inject constructor(
    private val localDataSource: WeatherLocalDataSource,
    private val remoteDataSource: WeatherRemoteDataSource,
    private val myRegionDataSource: MyRegionDataSource
) : DetailRepo {
    override fun getWeathers(
        regionId: Long,
        currentDateTime: Long
    ): Flow<ResultResource<WeatherModel?>> {
        return object : NetworkBoundResource<WeatherModel?, List<WeatherResponse>>() {
            override fun shouldFetch(data: WeatherModel?): Boolean {
                return data == null
            }

            override suspend fun saveRemoteData(response: List<WeatherResponse>) {
                localDataSource.saveRemote(regionId, response)
            }

            override fun fetchFromLocal(): Flow<WeatherModel?> {
                return localDataSource.getWeathers(
                    currentDateTime = currentDateTime,
                    regionId = regionId
                )
            }

            override suspend fun fetchFromRemote(): ResultResource<List<WeatherResponse>> {
                return ResultResource.Success(remoteDataSource.getWeathers(regionId))
            }

        }.asFlow()
    }

    override suspend fun saveRegion(regionModel: RegionModel) =
        myRegionDataSource.save(regionModel)


}