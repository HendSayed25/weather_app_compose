package com.example.weather_app_compose.presentaion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app_compose.data.mapper.toUIModel
import com.example.weather_app_compose.logic.entities.CurrentWeatherUI
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.usecase.GetCityNameUseCase
import com.example.weather_app_compose.logic.usecase.GetCurrentLocationUseCase
import com.example.weather_app_compose.logic.usecase.GetWeatherUseCase
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.presentaion.models.HourlyItem
import com.example.weather_app_compose.presentaion.models.WeatherUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherViewModel(
    private val weatherUseCase : GetWeatherUseCase,
    private val getCityNameUseCase : GetCityNameUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel(){

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _cityName = MutableStateFlow("")
    val cityName = _cityName.asStateFlow()

    private val _weatherData = MutableStateFlow<WeatherUIModel?>(null)
    val weatherData: StateFlow<WeatherUIModel?> = _weatherData

    private val _location = MutableStateFlow(Location(0.0,0.0))
    val location = _location.asStateFlow()

    private val _isDay =MutableStateFlow(0)
    val isDay = _isDay.asStateFlow()

    private val _currentWeather = MutableStateFlow<CurrentWeatherUI?>(null)
    val currentWeather: StateFlow<CurrentWeatherUI?> = _currentWeather

    private val _dayHoursItems = MutableStateFlow<List<HourlyItem?>>(emptyList())
    val dayHoursItems = _dayHoursItems.asStateFlow()

    private val _rain = MutableStateFlow("")
    val rain = _rain.asStateFlow()

    private val _wind = MutableStateFlow("")
    val wind = _wind.asStateFlow()

    private val _uvIndex = MutableStateFlow("")
    val uvIndex = _uvIndex.asStateFlow()

    private val _humidity = MutableStateFlow("")
    val humidity = _humidity.asStateFlow()

    private val _pressure = MutableStateFlow("")
    val pressure= _pressure.asStateFlow()

    private val _dailyForecastItems = MutableStateFlow<List<DailyForecastItem>>(emptyList())
    val dailyForecastItems = _dailyForecastItems.asStateFlow()


    init{
        loadWeatherData()
    }

    private fun loadWeatherData(){
        _isLoading.value = true

        viewModelScope.launch {
            try {
                _location.value = getCurrentLocationUseCase.getCurrentLocation()
                _cityName.value = getCityNameUseCase.getCityName(_location.value)
                val response =  weatherUseCase.getWeather(_location.value)
                val mappedData = response?.toUIModel()
                _weatherData.value = mappedData

                mappedData?.let {
                    _currentWeather.value = CurrentWeatherUI(
                        iconResId = it.currentImageId,
                        temperature = it.currentTemp.toInt().toString(),
                        description = it.weatherDescription,
                        maxTemp = it.maxTemp.toInt(),
                        minTemp = it.minTemp.toInt(),
                    )

                    _isDay.value = it.isDay

                    _rain.value = it.rain.toInt().toString()
                    _wind.value = it.windSpeed.toInt().toString()
                    _uvIndex.value = it.uvIndex.toInt().toString()
                    _pressure.value = it.pressure.toInt().toString()
                    _humidity.value = it.humidity.toString()


                    _dailyForecastItems.value =  it.dailyForecast.map { forecast ->
                        forecast.copy(
                            day = getDayName(forecast.day)
                        )
                    }

                    _dayHoursItems.value = it.hourlyItems.map {dailyItem->
                        dailyItem.copy(
                            time = extractHourWithAmPm(dailyItem.time)
                        )
                    }.distinctBy { it.time }
            }
            }catch (e:Exception){
                throw e
            }finally {
                _isLoading.value = false
            }
        }
    }

    private fun getDayName(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date: Date? = inputFormat.parse(dateString)

        val outputFormat = SimpleDateFormat("EEEE", Locale.getDefault()) // EEEE = Full day name
        return if (date != null) outputFormat.format(date) else "Unknown"
    }

    private fun extractHourWithAmPm(timeString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        val date = inputFormat.parse(timeString)

        val outputFormat = SimpleDateFormat("h a", Locale.getDefault()) // 12-hour format with AM/PM
        return if (date != null) outputFormat.format(date) else "Unknown"
    }


}