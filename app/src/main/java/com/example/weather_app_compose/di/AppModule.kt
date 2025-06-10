package com.example.weather_app_compose.di

import LocationRepositoryImp
import com.example.weather_app_compose.data.remote.datasource.GetCityNameDataSourceImp
import com.example.weather_app_compose.data.remote.datasource.IGetCityNameDataSource
import com.example.weather_app_compose.data.remote.datasource.ILocationRemoteDataSource
import com.example.weather_app_compose.data.remote.datasource.IWeatherRemoteDataSource
import com.example.weather_app_compose.data.remote.datasource.LocationRemoteDataSourceImp
import com.example.weather_app_compose.data.remote.datasource.WeatherRemoteDataSourceImp
import com.example.weather_app_compose.data.repository.GetCityNameRepositoryImp
import com.example.weather_app_compose.data.repository.WeatherRepositoryImp
import com.example.weather_app_compose.logic.repository.IGetCityNameRepository
import com.example.weather_app_compose.logic.repository.ILocationRepository
import com.example.weather_app_compose.logic.repository.IWeatherRepository
import com.example.weather_app_compose.logic.usecase.GetCityNameUseCase
import com.example.weather_app_compose.logic.usecase.GetCurrentLocationUseCase
import com.example.weather_app_compose.logic.usecase.GetWeatherUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {
    //data source

    single<IWeatherRemoteDataSource> { WeatherRemoteDataSourceImp(
        client = get()
    ) }
    single<ILocationRemoteDataSource> { 
        LocationRemoteDataSourceImp(
        context = get()
    ) }
    single <IGetCityNameDataSource>{ GetCityNameDataSourceImp(
        client = get()
    ) }
    
    //repositories

    single <IWeatherRepository>{ WeatherRepositoryImp(
        weatherRemoteDataSource = get()
    )  }
    single <ILocationRepository>{ LocationRepositoryImp(
        locationRemoteDataSource = get()
    ) }
    single<IGetCityNameRepository>{GetCityNameRepositoryImp(
        getCiyNameDataSource = get()
    )}

    //useCase

    single{
        GetWeatherUseCase(
        weatherRepo = get(),
        locationRepo = get()
    )}

    single { GetCurrentLocationUseCase(
        locationRepo = get()
    ) }

    single{
        GetCityNameUseCase(
            getCityNameRepo = get()
        )
    }

    //network
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
    }

}