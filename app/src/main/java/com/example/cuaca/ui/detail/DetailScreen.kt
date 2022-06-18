package com.example.cuaca.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cuaca.data.viewmodel.DetailViewModel
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel


@Composable
fun DetailScreen(
    region: RegionModel,
    enableSave: Boolean,
    viewModel: DetailViewModel = hiltViewModel(),
) {

    val state = viewModel.uiState.collectAsState()
    viewModel.getWeather(regionId = region.id)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        HeaderRegion(
            modifier = Modifier.fillMaxWidth(),
            region = region
        )
        when (state.value) {
            is ResultResource.Loading -> {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is ResultResource.Success -> {
                WeatherSection(
                    modifier = Modifier.fillMaxWidth(),
                    weather = state.value.data,
                    save = {
                        viewModel.saveMyRegion(region)
                    },
                    enableSave = enableSave
                )

            }
            else -> {}
        }
    }


}