package com.example.weather_app_compose.data.remote.datasource

import com.example.weather_app_compose.logic.entities.Location

interface IGetCityNameDataSource {
    suspend fun getCityNameFromCoordinates(location : Location) : String
}