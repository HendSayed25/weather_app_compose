package com.example.weather_app_compose.logic.usecase

import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.IWeatherRepository

class GetWeatherUseCase (
    private val weatherRepo : IWeatherRepository,
){

    suspend fun getWeather(location : Location) : WeatherResponse?{
        return weatherRepo.getWeatherByLocation(location)
    }
}