package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.logic.entities.WeatherState
import com.example.weather_app_compose.ui.theme.overlayColor
import com.example.weather_app_compose.ui.theme.valueOfCard
import com.example.weather_app_compose.ui.theme.white
import com.example.weather_app_compose.ui.theme.whiteWith70Alpha

@Composable
fun WeatherStateCard(
    modifier: Modifier = Modifier,
    weatherStateData : WeatherState,
){

    Box(
       modifier= modifier.background(MaterialTheme.colorScheme.onTertiary, shape = RoundedCornerShape(24.dp)),
        contentAlignment = Alignment.TopCenter
    ) {
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Image(
            painter = painterResource(weatherStateData.iconId),
            contentDescription = "icon for weather state"
        )
        Spacer(Modifier.height(8.dp))

        Text(
            text = weatherStateData.value,
            fontWeight = FontWeight.W500,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.tertiary
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = weatherStateData.state,
            color = MaterialTheme.colorScheme.background,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
        )
    }
    }
}