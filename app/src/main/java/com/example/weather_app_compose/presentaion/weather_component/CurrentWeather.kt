package com.example.weather_app_compose.presentaion.weather_component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.logic.entities.CurrentWeatherUI
import com.example.weather_app_compose.ui.theme.overlayColor
import com.example.weather_app_compose.ui.theme.textColorTitle

@Composable
fun CurrentWeather(
    currentWeather: CurrentWeatherUI?
){

    Image(
        painter = painterResource(currentWeather?.iconResId ?: R.drawable.weather_icon),
        contentDescription = "current weather icon",
        modifier = Modifier.padding(start = 67.dp, end = 72.5.dp),
    )
    Text(
        text = currentWeather?.temperature?:"",
        fontSize = 64.sp,
        fontWeight = FontWeight.W600,
        color = textColorTitle,
        modifier = Modifier.padding(start = 107.dp, end = 107.dp, top = 12.dp)
    )
    Text(
        text = currentWeather?.description?: "",
        color = overlayColor,
        fontSize =16.sp,
        fontWeight = FontWeight.W500
    )
    Spacer(Modifier.height(12.dp))

    MinMaxDegree(currentWeather?.maxTemp.toString(),currentWeather?.minTemp.toString())
}