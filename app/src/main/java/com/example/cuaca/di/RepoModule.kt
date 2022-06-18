package com.example.cuaca.di

import com.example.cuaca.data.source.local.MyRegionDataSource
import com.example.cuaca.data.source.local.RegionLocalDataSource
import com.example.cuaca.data.source.local.WeatherLocalDataSource
import com.example.cuaca.data.source.remote.RegionRemoteDataSource
import com.example.cuaca.data.source.remote.WeatherRemoteDataSource
import com.example.cuaca.data.source.repo.RegionRepo
import com.example.cuaca.data.source.repo.RegionRepoImp
import com.example.cuaca.data.source.repo.DetailRepo
import com.example.cuaca.data.source.repo.DetailRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {

    @ViewModelScoped
    @Provides
    fun provideRegionRepo(
        localDataSource: RegionLocalDataSource,
        remoteDataSource: RegionRemoteDataSource,
        myRegionDataSource: MyRegionDataSource
    ): RegionRepo {
        return RegionRepoImp(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource,
            myRegionDataSource = myRegionDataSource
        )
    }


    @ViewModelScoped
    @Provides
    fun provideDetailRepo(
        localDataSource: WeatherLocalDataSource,
        myRegionDataSource: MyRegionDataSource,
        remoteDataSource: WeatherRemoteDataSource
    ): DetailRepo {
        return DetailRepoImp(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource,
            myRegionDataSource = myRegionDataSource
        )
    }
}