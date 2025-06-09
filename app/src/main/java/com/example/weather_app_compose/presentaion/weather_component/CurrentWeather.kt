package com.example.weather_app_compose.presentaion.weather_component

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
import com.example.weather_app_compose.ui.theme.overlayColor
import com.example.weather_app_compose.ui.theme.textColorTitle

@Composable
fun CurrentWeather(){
    Image(
        painter = painterResource(R.drawable.weather_icon),
        contentDescription = "current weather icon",
        modifier = Modifier.padding(start = 67.dp, end = 72.5.dp),
    )
    Text(
        text = "24 C",
        fontSize = 64.sp,
        fontWeight = FontWeight.W600,
        color = textColorTitle,
        modifier = Modifier.padding(start = 107.dp, end = 107.dp, top = 12.dp)
    )
    Text(
        text = "cloudy",
        color = overlayColor,
        fontSize =16.sp,
        fontWeight = FontWeight.W500
    )
    Spacer(Modifier.height(12.dp))

    MinMaxDegree()
}