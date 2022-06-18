package com.example.cuaca.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cuaca.data.viewmodel.RegionVIewModel
import com.example.cuaca.di.ResultResource
import com.example.cuaca.model.RegionModel
import com.example.cuaca.ui.main.MyRegionItem
import com.example.cuaca.ui.main.RegionItem
import com.example.cuaca.ui.main.TabSection

@Composable
fun MainScreen(viewModel: RegionVIewModel = hiltViewModel(), onItemClick: (RegionModel,Boolean) -> Unit) {
    val state = viewModel.regionState.collectAsState()
    val myRegionstate = viewModel.myRegionState.collectAsState()
    val isRegionState = viewModel.isRegionTab.collectAsState()

    Column {
        Row(Modifier.fillMaxWidth()) {
            TabSection(
                modifier = Modifier
                    .clickable {
                        viewModel.setTab(true)
                    }
                    .wrapContentHeight()
                    .weight(1f),
                isSelected = isRegionState.value,
                text = "Kota"
            )
            TabSection(
                modifier = Modifier
                    .clickable {
                        viewModel.setTab(false)
                    }
                    .wrapContentHeight()
                    .weight(1f),
                isSelected = !isRegionState.value,
                text = "Kota Saya"
            )
        }
        if (isRegionState.value) {
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
                    state.value.data?.let {
                        LazyColumn {
                            items(it) { data ->
                                Column() {
                                    RegionItem(
                                        region = data,
                                        onItemClick = {
                                            onItemClick.invoke(data,true)
                                        })
                                    Divider(
                                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }

                            }
                        }
                    }
                }
                else -> {
                }
            }
        } else {
            LazyColumn {
                items(myRegionstate.value) { data ->
                    Column() {
                        MyRegionItem(
                            region = data,
                            onItemClick = {
                                onItemClick.invoke(data,false)
                            },
                            onDeleteItem = {
                                viewModel.deleteMyRegion(it)
                            }
                        )
                        Divider(
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }
            }
        }

    }

}