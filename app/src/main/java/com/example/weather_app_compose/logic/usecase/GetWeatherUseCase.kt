package com.example.weather_app_compose.logic.usecase

import android.util.Log
import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.repository.ILocationRepository
import com.example.weather_app_compose.logic.repository.IWeatherRepository

class GetWeatherUseCase (
    private val weatherRepo : IWeatherRepository,
    private val locationRepo : ILocationRepository
){

    suspend fun getWeather() : WeatherResponse?{
        val location = GetCurrentLocationUseCase(locationRepo).getCurrentLocation()
        Log.e("Before Calling Repo","///////////////////")
        return weatherRepo.getWeatherByLocation(location)
    }
}