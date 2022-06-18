package com.example.cuaca.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuaca.data.source.repo.RegionRepo
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionVIewModel @Inject constructor(val repo: RegionRepo) : ViewModel() {
    private val _regionState = MutableStateFlow<ResultResource<List<RegionModel>>>(ResultResource.Loading())
    val regionState:StateFlow<ResultResource<List<RegionModel>>> get() = _regionState

    private val _myRegionState = MutableStateFlow<List<RegionModel>>(listOf())
    val myRegionState:StateFlow<List<RegionModel>> get() = _myRegionState

    private val _isRegionTab= MutableStateFlow(true)
    val isRegionTab:StateFlow<Boolean> get() = _isRegionTab


    init {
        getRegions()
        getMyRegions()
    }

    fun getRegions() = viewModelScope.launch {
      repo.getRegions().collectLatest { result->
          _regionState.update {
              result
          }
      }
    }

    fun deleteMyRegion(regionModel: RegionModel) = viewModelScope.launch {
       repo.deleteMyRegion(regionModel)
    }

    fun getMyRegions() = viewModelScope.launch {
        repo.getMyRegions().collectLatest { result->
            _myRegionState.update {
                result
            }
        }
    }

    fun setTab(isRegion:Boolean){
        _isRegionTab.update {
            isRegion
        }
    }
}