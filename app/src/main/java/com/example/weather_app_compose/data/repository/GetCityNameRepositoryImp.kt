package com.example.weather_app_compose.data.repository

import com.example.weather_app_compose.data.remote.datasource.IGetCityNameDataSource
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.IGetCityNameRepository


class GetCityNameRepositoryImp(
    private val getCiyNameDataSource: IGetCityNameDataSource
) : IGetCityNameRepository {

    override suspend fun getCityNameFromCoordinates(location: Location): String {
        return getCiyNameDataSource.getCityNameFromCoordinates(location)
    }
}