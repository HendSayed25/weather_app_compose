package com.example.weather_app_compose.data.repository

import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.ILocationRepository

class LocationRepositoryImp () : ILocationRepository{
    override fun getLocationByIpAddress(): Location {
        TODO("Not yet implemented")
    }

}