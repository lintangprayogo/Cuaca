package com.example.cuaca.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cuaca.model.RegionModel

@Composable
fun HeaderRegion(modifier: Modifier, region: RegionModel) {
    Row(
        modifier = modifier.padding(16.dp)
    ) {

        val centerVertically = Modifier.align(Alignment.CenterVertically)

        Icon(
            imageVector = Icons.Rounded.Place,
            contentDescription = null,
            modifier = centerVertically
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Column(
            modifier = centerVertically.fillMaxWidth()
        ) {
            Text(
                text = region.district,
                style = MaterialTheme.typography.h6,
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "${region.city}, ${region.province}.",
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}
