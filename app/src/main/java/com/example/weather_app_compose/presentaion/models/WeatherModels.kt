package com.example.weather_app_compose.presentaion.models

data class WeatherUIModel(
    val currentTemp: Double,
    val weatherDescription: String,
    val maxTemp: Double,
    val minTemp: Double,
    val windSpeed: Double,
    val humidity: Int,
    val pressure: Double,
    val rain: Double,
    val uvIndex : Double,
    val hourlyItems: List<HourlyItem>,
    val hourlyImages: List<Int>,
    val dailyForecast: List<DailyForecastItem>,
    val currentImageId : Int,

)

data class HourlyItem(
    val time: String,
    val temp: Double,
    val weatherCode: Int,
    val imageId :Int
)

data class DailyForecastItem(
    val day: String,
    val minTemp: Double,
    val maxTemp: Double,
    val weatherCode: Int,
    val imageId: Int
)