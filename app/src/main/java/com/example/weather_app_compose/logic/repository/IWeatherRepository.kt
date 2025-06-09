package com.example.weather_app_compose.logic.repository

import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location

interface IWeatherRepository {
    fun getWeatherByLocation(location : Location) : WeatherResponse
}