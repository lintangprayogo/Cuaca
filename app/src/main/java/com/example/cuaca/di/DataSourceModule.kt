package com.example.cuaca.di

import com.example.cuaca.data.source.local.*
import com.example.cuaca.data.source.remote.*
import com.example.cuaca.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRegionRemoteDataSource(apiService: ApiService): RegionRemoteDataSource {
        return RegionRemoteDataSourceImp(apiService)
    }

    @Provides
    @Singleton
    fun provideRegionLocalDataSource(appDatabase: AppDatabase): RegionLocalDataSource {
        return RegionLocalDataSourceImp(appDatabase)
    }

    @Provides
    @Singleton
    fun provideWeatherRemoteDataSource(apiService: ApiService): WeatherRemoteDataSource{
        return WeatherRemoteDataSourceImp(apiService)
    }

    @Provides
    @Singleton
    fun provideWeatherLocalDataSource(appDatabase: AppDatabase): WeatherLocalDataSource {
        return WeatherLocalDataSourceImp(appDatabase)
    }

    @Provides
    @Singleton
    fun provideMyRegionDataSource(appDatabase: AppDatabase): MyRegionDataSource {
        return MyRegionDataSourceImp(appDatabase)
    }

}