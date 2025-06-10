package com.example.weather_app_compose.logic.usecase

import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.ILocationRepository

class GetCurrentLocationUseCase(
    private val locationRepo : ILocationRepository
) {

    suspend fun getCurrentLocation():Location{
        return locationRepo.getCurrentLocation()
    }

}