package com.example.weather_app_compose.data.remote.datasource

import android.util.Log
import com.example.weather_app_compose.logic.entities.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.net.HttpURLConnection
import java.net.URL

class GetCityNameDataSourceImp(
    private val getCityNameDataSource: IGetCityNameDataSource
) : IGetCityNameDataSource{

    override suspend fun getCityNameFromCoordinates(location: Location): String {
        val apiKey = "4aec5a949fdeddcb53a7c6dc0e0091ab"
        val url = "https://api.openweathermap.org/geo/1.0/reverse?lat=${location.latitude}&lon=${location.longitude}&limit=1&appid=$apiKey"

        return withContext(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val stream = connection.inputStream.bufferedReader().use { it.readText() }
                    val jsonObject = Json.parseToJsonElement(stream).jsonObject
                    Log.e("cityName",
                        jsonObject["name"].toString()
                    )
                    jsonObject["name"]?.jsonPrimitive?.content?:"UnKnown"

                } else "Unknown"
            } catch (e: Exception) {
                "Unknown"
            }
        }
    }
}