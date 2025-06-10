package com.example.weather_app_compose.data.remote.datasource

import android.util.Log
import com.example.weather_app_compose.logic.entities.Location
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.*

class GetCityNameDataSourceImp (
    private val client : HttpClient
): IGetCityNameDataSource {


    override suspend fun getCityNameFromCoordinates(location: Location): String {
        val apiKey = "4aec5a949fdeddcb53a7c6dc0e0091ab"
        val url =
            "https://api.openweathermap.org/geo/1.0/reverse?lat=${location.latitude}&lon=${location.longitude}&limit=1&appid=$apiKey"

        return try {
            val response: JsonArray = client.get(url).body()

            val cityName = response.firstOrNull()?.jsonObject?.get("name")?.jsonPrimitive?.contentOrNull ?: "Unknown"

            Log.e("cityName", cityName)

            cityName
        } catch (e: Exception) {
            e.printStackTrace()
            "Unknown"
        }
    }
}
