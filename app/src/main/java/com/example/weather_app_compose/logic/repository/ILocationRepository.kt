package com.example.weather_app_compose.logic.repository

import com.example.weather_app_compose.logic.entities.Location

interface ILocationRepository {
    suspend fun getCurrentLocation () : Location
}