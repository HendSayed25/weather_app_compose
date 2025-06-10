package com.example.weather_app_compose.logic.usecase

import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.IGetCityNameRepository

class GetCityNameUseCase(
    private val getCityNameRepo : IGetCityNameRepository
) {

    suspend fun getCityName(location : Location): String {
        return getCityNameRepo.getCityNameFromCoordinates(location)
    }
}