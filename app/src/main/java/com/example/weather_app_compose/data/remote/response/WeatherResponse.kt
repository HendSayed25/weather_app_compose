package com.example.weather_app_compose.data.remote.response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(

	@SerialName("elevation")
	val elevation: Double? = null,

	@SerialName("daily_units")
	val dailyUnits: DailyUnits? = null,

	@SerialName("timezone")
	val timezone: String? = null,

	@SerialName("latitude")
	val latitude: Double? = null,

	@SerialName("hourly_units")
	val hourlyUnits: HourlyUnits? = null,

	@SerialName("generationtime_ms")
	val generationTimeMs: Double? = null,

	@SerialName("current")
	val current: Current? = null,

	@SerialName("timezone_abbreviation")
	val timezoneAbbreviation: String? = null,

	@SerialName("current_units")
	val currentUnits: CurrentUnits? = null,

	@SerialName("daily")
	val daily: Daily? = null,

	@SerialName("utc_offset_seconds")
	val utcOffsetSeconds: Int? = null,

	@SerialName("hourly")
	val hourly: Hourly? = null,

	@SerialName("longitude")
	val longitude: Double? = null
)

@Serializable
data class CurrentUnits(

	@SerialName("wind_speed_10m")
	val windSpeed10m: String? = null,

	@SerialName("temperature_2m")
	val temperature2m: String? = null,

	@SerialName("rain")
	val rain: String? = null,

	@SerialName("surface_pressure")
	val surfacePressure: String? = null,

	@SerialName("relative_humidity_2m")
	val relativeHumidity2m: String? = null,

	@SerialName("is_day")
	val isDay: String? = null,

	@SerialName("interval")
	val interval: String? = null,

	@SerialName("time")
	val time: String? = null,

	@SerialName("weather_code")
	val weatherCode: String? = null
)

@Serializable
data class Hourly(

	@SerialName("temperature_2m")
	val temperature2m: List<Double?>? = null,

	@SerialName("time")
	val time: List<String?>? = null,

	@SerialName("weather_code")
	val weatherCode: List<Int?>? = null
)

@Serializable
data class DailyUnits(

	@SerialName("uv_index_max")
	val uvIndexMax: String? = null,

	@SerialName("temperature_2m_max")
	val temperature2mMax: String? = null,

	@SerialName("temperature_2m_min")
	val temperature2mMin: String? = null,

	@SerialName("time")
	val time: String? = null,

	@SerialName("weather_code")
	val weatherCode: String? = null
)

@Serializable
data class HourlyUnits(

	@SerialName("temperature_2m")
	val temperature2m: String? = null,

	@SerialName("time")
	val time: String? = null,

	@SerialName("weather_code")
	val weatherCode: String? = null
)

@Serializable
data class Current(

	@SerialName("wind_speed_10m")
	val windSpeed10m: Double? = null,

	@SerialName("temperature_2m")
	val temperature2m: Double? = null,

	@SerialName("rain")
	val rain: Double? = null,

	@SerialName("surface_pressure")
	val surfacePressure: Double? = null,

	@SerialName("relative_humidity_2m")
	val relativeHumidity2m: Int? = null,

	@SerialName("is_day")
	val isDay: Int? = null,

	@SerialName("interval")
	val interval: Int? = null,

	@SerialName("time")
	val time: String? = null,

	@SerialName("weather_code")
	val weatherCode: Int? = null
)

@Serializable
data class Daily(

	@SerialName("uv_index_max")
	val uvIndexMax: List<Double?>? = null,

	@SerialName("temperature_2m_max")
	val temperature2mMax: List<Double?>? = null,

	@SerialName("temperature_2m_min")
	val temperature2mMin: List<Double?>? = null,

	@SerialName("time")
	val time: List<String?>? = null,

	@SerialName("weather_code")
	val weatherCode: List<Int?>? = null
)
