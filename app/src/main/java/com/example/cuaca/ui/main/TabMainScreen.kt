package com.example.cuaca.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
 fun TabSection(modifier: Modifier, isSelected: Boolean, text: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val textColor: Color = if (isSelected) {
            Color.Cyan
        } else {
            Color.Black
        }

        val underLineColor: Color
        val thickness: Dp
        if (isSelected) {
            underLineColor = Color.Cyan
            thickness = 2.dp
        } else {
            underLineColor = Color.Black
            thickness = 1.dp
        }

        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = text,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Divider(color = underLineColor, thickness = thickness)
    }
}