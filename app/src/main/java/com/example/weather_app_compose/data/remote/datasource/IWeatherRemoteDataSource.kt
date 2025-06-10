package com.example.weather_app_compose.data.remote.datasource

import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location

interface IWeatherRemoteDataSource {
    suspend fun getWeather(location : Location) : WeatherResponse?
}