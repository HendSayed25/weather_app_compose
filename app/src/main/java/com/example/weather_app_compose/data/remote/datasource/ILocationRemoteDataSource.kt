package com.example.weather_app_compose.data.remote.datasource

import com.example.weather_app_compose.logic.entities.Location

interface ILocationRemoteDataSource {
    suspend fun getCurrentLocation() : Location
}