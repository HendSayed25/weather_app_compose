package com.example.weather_app_compose.data.remote.datasource

import android.util.Log
import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class WeatherRemoteDataSourceImp :IWeatherRemoteDataSource{

    override suspend fun getWeather(location: Location): WeatherResponse? {
        val url =
            "https://api.open-meteo.com/v1/forecast?latitude=${location.latitude}&longitude=${location.longitude}&daily=uv_index_max,weather_code,temperature_2m_max,temperature_2m_min&hourly=temperature_2m,weather_code&current=temperature_2m,relative_humidity_2m,is_day,rain,weather_code,wind_speed_10m,surface_pressure"

        Log.e("before context dispatcher......","////////////")
        return withContext(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                Log.e("WeatherRepositoryImp", "Before connect")
                connection.connect()
                Log.e("WeatherRepositoryImp", "After connect")
                Log.e("Before fetching","fffffffffffffffffff")

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val responseText = connection.inputStream.bufferedReader().use { it.readText() }
                    Log.e("weatherResponse",
                        Json.decodeFromString<WeatherResponse>(responseText).toString()
                    )

                    Json.decodeFromString<WeatherResponse>(responseText)
                } else null
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

}