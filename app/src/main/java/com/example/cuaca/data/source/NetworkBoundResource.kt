package com.example.cuaca.data.source

import android.util.Log
import com.example.cuaca.di.ResultResource
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    fun asFlow() = flow<ResultResource<ResultType>> {
        // emit Database data first
        if (shouldFetch(fetchFromLocal().first())) {
            emit(ResultResource.Loading())

            // fetch from remote
            val apiResponse = fetchFromRemote()

            // lakukan checking apabila berhasil mendapatkan data
            if (apiResponse is ResultResource.Success) {
                // simpan data ke local
                apiResponse.data?.let {
                    saveRemoteData(it)
                }

            } else {
                // Kalo Error
                Log.d("TAG", "asFlow: ${apiResponse.throwable?.localizedMessage}")
                emit(ResultResource.Error(throwable = apiResponse.throwable))
            }
        }

        emitAll(fetchFromLocal().map { ResultResource.Success(it) })
    }

    /**
     * Sebuah Fungsi Untuk Mengchek apakah harus mengambil dari remote
     */
    protected abstract fun shouldFetch(data: ResultType): Boolean


    protected abstract suspend fun saveRemoteData(response: RequestType)


    protected abstract fun fetchFromLocal(): Flow<ResultType>


    protected abstract suspend fun fetchFromRemote(): ResultResource<RequestType>
}