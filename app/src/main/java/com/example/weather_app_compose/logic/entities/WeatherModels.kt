package com.example.weather_app_compose.logic.entities

data class WeatherState(
    val iconId : Int,
    val value : String,
    val state : String
)


data class CurrentWeatherUI(
    val iconResId: Int,
    val temperature: String,
    val description: String,
    val maxTemp :Int,
    val minTemp : Int
)


