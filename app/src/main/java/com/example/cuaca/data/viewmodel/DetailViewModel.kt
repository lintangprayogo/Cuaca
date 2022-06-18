package com.example.cuaca.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuaca.data.source.repo.DetailRepo
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import com.example.cuaca.model.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val weatherRepo: DetailRepo) : ViewModel() {
    private val _uiState = MutableStateFlow<ResultResource<WeatherModel?>>(ResultResource.Loading())
    val uiState: StateFlow<ResultResource<WeatherModel?>> get() = _uiState

    fun getWeather(
        dateTime:Long= System.currentTimeMillis(),
        regionId: Long
    ) = viewModelScope.launch {
        weatherRepo.getWeathers(regionId = regionId, currentDateTime = dateTime).collectLatest { result ->
            _uiState.update {
                result
            }
        }
    }

    fun saveMyRegion(regionModel: RegionModel)= viewModelScope.launch {
        weatherRepo.saveRegion(regionModel)
    }
}