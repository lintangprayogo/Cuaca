package com.example.cuaca.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cuaca.R
import com.example.cuaca.model.WeatherModel
import com.example.cuaca.model.asWeatherAnimId

@Composable
fun WeatherSection(
    modifier: Modifier,
    enableSave: Boolean,
    weather: WeatherModel?,
    save: () -> Unit,
) {
    if (weather == null) {
        return
    }
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(weather.code.asWeatherAnimId())
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LottieAnimation(
            composition = composition,
            iterations = Int.MAX_VALUE,
            modifier = Modifier
                .size(190.dp)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.padding(8.dp))
        Text(
            text = weather.name,
            style = MaterialTheme.typography.body2.copy(fontSize = 20.sp),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.temp_c, weather.tempC),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "${weather.tempF} ℉ ${weather.humidity}",
                style = MaterialTheme.typography.body2
            )

            Spacer(Modifier.padding(1.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_humidity),
                contentDescription = "",
                modifier = Modifier
                    .size(10.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(Modifier.padding(8.dp))
        if (enableSave) {
            Button(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                onClick = {
                    save.invoke()
                }) {
                Text(text = "SIMPAN")
            }
        }
    }
}