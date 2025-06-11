package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.R

@Composable
fun LocationDesign(
    cityName : String,
    isDay : Int
){
    Row(modifier = Modifier.padding(start = 133.dp, end = 133.dp, top = 50.dp, bottom = 12.dp)){

        Image(
            painter =painterResource(if (isDay == 1) R.drawable.location else R.drawable.location_dark),
            contentDescription = "location icon"
        )
        Box (Modifier.padding(start = 4.dp, top = 2.dp, bottom = 2.dp)){
            Text(
                text = cityName ,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}