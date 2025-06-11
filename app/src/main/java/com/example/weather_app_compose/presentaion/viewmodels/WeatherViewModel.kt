package com.example.weather_app_compose.presentaion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app_compose.data.mapper.toUIModel
import com.example.weather_app_compose.logic.entities.CurrentWeatherUI
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.entities.WeatherHour
import com.example.weather_app_compose.logic.entities.WeatherState
import com.example.weather_app_compose.logic.usecase.GetCityNameUseCase
import com.example.weather_app_compose.logic.usecase.GetCurrentLocationUseCase
import com.example.weather_app_compose.logic.usecase.GetWeatherUseCase
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.presentaion.models.WeatherUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherUseCase : GetWeatherUseCase,
    private val getCityNameUseCase : GetCityNameUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel(){

    private val _cityName = MutableStateFlow("")
    val cityName = _cityName.asStateFlow()

    private val _weatherData = MutableStateFlow<WeatherUIModel?>(null)
    val weatherData: StateFlow<WeatherUIModel?> = _weatherData

    private val _location = MutableStateFlow(Location(0.0,0.0))
    val location = _location.asStateFlow()

    private val _currentWeather = MutableStateFlow<CurrentWeatherUI?>(null)
    val currentWeather: StateFlow<CurrentWeatherUI?> = _currentWeather

    private val _dayHours = MutableStateFlow<List<WeatherHour?>>(emptyList())
    val dayHours = _dayHours.asStateFlow()

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
        viewModelScope.launch {
            _location.value = getCurrentLocationUseCase.getCurrentLocation()
            _cityName.value = getCityNameUseCase.getCityName(_location.value)
            val response =  weatherUseCase.getWeather()
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

                _rain.value = it.rain.toInt().toString()
                _wind.value = it.windSpeed.toInt().toString()
                _uvIndex.value = it.uvIndex.toInt().toString()
                _pressure.value = it.pressure.toInt().toString()
                _humidity.value = it.humidity.toInt().toString()

                _dailyForecastItems.value = it.dailyForecast



                //  _dayHours.value = it.hourlyTemperatures.take(24)




            }
        }
    }
}