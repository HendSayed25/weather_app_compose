package com.example.weather_app_compose.logic.entities

data class WeatherState(
    val iconId : Int,
    val value : String,
    val state : String
)

data class WeatherHour(
    val temperature: String,
    val hour: String,
    val iconResId: Int
)

data class WeatherDay(
    val day: String,
    val iconResId: Int,
    val maxTemperature: String,
    val minTemperature : String
)

data class CurrentWeather(
    val iconResId: Int,
    val temperature: String,
    val description: String,
)
