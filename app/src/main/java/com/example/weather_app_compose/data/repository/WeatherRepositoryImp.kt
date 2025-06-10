package com.example.weather_app_compose.data.repository

import android.util.Log
import com.example.weather_app_compose.data.remote.datasource.IWeatherRemoteDataSource
import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.IWeatherRepository


class WeatherRepositoryImp (
    private val weatherRemoteDataSource : IWeatherRemoteDataSource
): IWeatherRepository {
    override suspend fun getWeatherByLocation(location: Location): WeatherResponse? {
        Log.e("inside weather Repo Imp","///////////////////")

        return weatherRemoteDataSource.getWeather(location)
    }
}