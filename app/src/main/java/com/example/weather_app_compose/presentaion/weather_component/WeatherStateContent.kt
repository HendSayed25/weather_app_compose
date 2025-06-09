package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.logic.entities.WeatherState


val weatherStates : List<WeatherState> = listOf(
    WeatherState(
        iconId = R.drawable.fast_wind,
        value = "13 km/h",
        state = "wind"
    ),
    WeatherState(
        iconId = R.drawable.humidity,
        value = "24 %",
        state = "Humidity"
    ), WeatherState(
        iconId = R.drawable.rain,
        value = "2 %",
        state = "Rain"
    ), WeatherState(
        iconId = R.drawable.uv,
        value = "2",
        state = "UV Index"
    ), WeatherState(
        iconId = R.drawable.arrow_down_blue,
        value = "1012 hPa",
        state = "Pressure"
    ), WeatherState(
        iconId = R.drawable.temperature,
        value = "22 C",
        state = "Feels like"
    ),

    )


@Composable
fun WeatherStateContent() {
    Column (
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp).padding(top=24.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherStateCard(Modifier.weight(1f),weatherStates[0])
            WeatherStateCard(Modifier.weight(1f),weatherStates[1])
            WeatherStateCard(Modifier.weight(1f),weatherStates[2])
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherStateCard(Modifier.weight(1f),weatherStates[3])
            WeatherStateCard(Modifier.weight(1f),weatherStates[4])
            WeatherStateCard(Modifier.weight(1f),weatherStates[5])
        }
        Spacer(Modifier.height(24.dp))
    }
}