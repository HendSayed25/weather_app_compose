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
import com.example.weather_app_compose.logic.entities.WeatherState


@Composable
fun WeatherStateContent(
    weatherStates :List<WeatherState>
) {
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