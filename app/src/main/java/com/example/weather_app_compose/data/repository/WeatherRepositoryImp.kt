package com.example.weather_app_compose.data.repository

import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.IWeatherRepository

class WeatherRepositoryImp : IWeatherRepository {
    override fun getWeatherByLocation(location: Location): WeatherResponse {
        TODO("Not yet implemented")
    }

}