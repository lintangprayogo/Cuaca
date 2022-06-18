package com.example.cuaca.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cuaca.model.RegionModel
import com.example.cuaca.R


@Composable
fun MyRegionItem(
    modifier: Modifier = Modifier,
    region: RegionModel,
    onItemClick: (RegionModel) -> Unit,
    onDeleteItem: (RegionModel) -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onItemClick.invoke(region)
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_city),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Spacer(modifier = modifier.padding(8.dp))

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = region.district,
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(modifier = modifier.padding(8.dp))

            Text(
                text = "${region.city}, ${region.province}.",
                style = MaterialTheme.typography.body2,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { onDeleteItem.invoke(region) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = ""
            )
        }
    }
}