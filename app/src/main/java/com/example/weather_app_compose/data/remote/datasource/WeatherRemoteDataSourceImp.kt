package com.example.weather_app_compose.data.remote.datasource

import android.util.Log
import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherRemoteDataSourceImp : IWeatherRemoteDataSource {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    override suspend fun getWeather(location: Location): WeatherResponse? {
        return try {
            val url = "https://api.open-meteo.com/v1/forecast" +
                    "?latitude=${location.latitude}" +
                    "&longitude=${location.longitude}" +
                    "&daily=uv_index_max,weather_code,temperature_2m_max,temperature_2m_min" +
                    "&hourly=temperature_2m,weather_code" +
                    "&current=temperature_2m,relative_humidity_2m,is_day,rain,weather_code,wind_speed_10m,surface_pressure"

            Log.e("Ktor Request", "Requesting URL: $url")

            val response: HttpResponse = client.get(url)

            if (response.status.value == 200) {
                val weatherResponse: WeatherResponse = response.body()
                Log.e("Ktor Response", weatherResponse.toString())
                weatherResponse
            } else {
                Log.e("Ktor Error", "Failed with status: ${response.status}")
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
