package com.example.weather_app_compose.data.mapper

import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.presentaion.models.HourlyItem
import com.example.weather_app_compose.presentaion.models.WeatherUIModel
import java.util.Date

fun WeatherResponse.toUIModel(): WeatherUIModel? {
    val current = current ?: return null
    val daily = daily ?: return null
    val hourly = hourly ?: return null

    val hourlyItems = mutableListOf<HourlyItem>()
    val hourlyImages = mutableListOf<Int>()
    val dailyForecast = mutableListOf<DailyForecastItem>()

    val times = hourly.time ?: emptyList()
    val temps = hourly.temperature2m ?: emptyList()
    val codes = hourly.weatherCode ?: emptyList()

    for (i in times.indices) {
        val time = times.getOrNull(i)
        val temp = temps.getOrNull(i)
        val code = codes.getOrNull(i)

        if (time != null && temp != null && code != null) {
            hourlyItems.add(
                HourlyItem(
                    time = time,
                    temp = temp,
                    weatherCode = code,
                    imageId = getWeatherIconRes(code,current.isDay)
                )
            )
            hourlyImages.add(getWeatherIconRes(code, current.isDay ?: 1))
        }
    }

    val currentImageId = getWeatherIconRes(current.weatherCode ?: 0, current.isDay ?: 1)

    val dates = daily.time ?: emptyList()
    val minTemps = daily.temperature2mMin ?: emptyList()
    val maxTemps = daily.temperature2mMax ?: emptyList()
    val weatherCodes = daily.weatherCode ?: emptyList()

    for (i in dates.indices) {
        val day = dates.getOrNull(i) ?: continue
        val min = minTemps.getOrNull(i) ?: continue
        val max = maxTemps.getOrNull(i) ?: continue
        val code = weatherCodes.getOrNull(i) ?: continue
        val imageId = getWeatherIconRes(code, current.isDay)

        dailyForecast.add(
            DailyForecastItem(
                day = day,
                minTemp = min,
                maxTemp = max,
                weatherCode = code,
                imageId = imageId
            )
        )
    }

    return WeatherUIModel(
        currentTemp = current.temperature2m ?: 0.0,
        weatherDescription = getWeatherDescriptionFromCode(current.weatherCode),
        maxTemp = daily.temperature2mMax?.getOrNull(0) ?: 0.0,
        minTemp = daily.temperature2mMin?.getOrNull(0) ?: 0.0,
        windSpeed = current.windSpeed10m ?: 0.0,
        humidity = current.relativeHumidity2m ?: 0,
        pressure = current.surfacePressure ?: 0.0,
        rain = current.rain ?: 0.0,
        uvIndex = daily.uvIndexMax?.getOrNull(0) ?: 0.0,
        hourlyItems = hourlyItems,
        currentImageId = currentImageId,
        dailyForecast = dailyForecast,
        hourlyImages = hourlyImages
    )
}

