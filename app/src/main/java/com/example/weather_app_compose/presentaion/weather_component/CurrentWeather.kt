package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.logic.entities.CurrentWeatherUI
import com.example.weather_app_compose.ui.theme.white


@Composable
fun CurrentWeather(
    currentWeather: CurrentWeatherUI?,
    isDay: Int,
    isScrolled: Boolean
) {
    AnimatedContent(
        targetState = isScrolled,
        label = "ScrollChange"
    ) { scrolled ->

        if (!scrolled) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(currentWeather?.iconResId ?: R.drawable.weather_icon),
                    contentDescription = "current weather icon",
                    modifier = Modifier
                        .size(width = 227.dp, height = 200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetails(
                    currentWeather = currentWeather,
                    isDay = isDay,
                    centered = true
                )
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(currentWeather?.iconResId ?: R.drawable.weather_icon),
                    contentDescription = "current weather icon",
                    modifier = Modifier
                        .size(width = 124.dp, height = 112.dp)
                        .padding(end = 16.dp)
                )
                WeatherDetails(
                    modifier = Modifier.weight(1f),
                    currentWeather = currentWeather,
                    isDay = isDay,
                    centered = true
                )
            }
        }
    }
}

@Composable
private fun WeatherDetails(
    modifier: Modifier = Modifier,
    currentWeather: CurrentWeatherUI?,
    isDay: Int,
    centered: Boolean
) {
    Column(
        modifier = modifier,
        horizontalAlignment = if (centered) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = "${currentWeather?.temperature}°C",
            fontSize = 64.sp,
            fontWeight = FontWeight.W600,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            text = currentWeather?.description?: "",
            color = MaterialTheme.colorScheme.background,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500
        )

        Spacer(Modifier.height(8.dp))

        MinMaxDegree(currentWeather?.maxTemp.toString(),currentWeather?.minTemp.toString(),isDay)
    }
}