package com.example.weather_app_compose

import LocationRepositoryImp
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.weather_app_compose.logic.usecase.GetWeatherUseCase
import com.example.weather_app_compose.presentaion.WeatherScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.mp.KoinPlatform.getKoin

class MainActivity : ComponentActivity() {
    private val getWeatherUseCase: GetWeatherUseCase = getKoin().get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Start the permission check process
        checkLocationPermissionsAndProceed()

        setContent {
            WeatherScreen()
        }
    }


    // Function to check and request location permissions
    private fun checkLocationPermissionsAndProceed() {
        val fineLocationGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val coarseLocationGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (fineLocationGranted || coarseLocationGranted) {
            Log.d("MainActivity", "Location permission already granted. Fetching weather.")
            fetchWeatherData()
        } else {
            Log.d("MainActivity", "Requesting location permission.")
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
100
            )
        }
    }


    // Function to fetch weather data using the use case
    private fun fetchWeatherData() {
        Log.d("MainActivity", "fetchWeatherData called. Launching coroutine...") // NEW LOG

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    Log.d("MainActivity", "Coroutine launched. Calling getWeatherUseCase.getWeather()...") // NEW LOG

                    val weatherData = getWeatherUseCase.getWeather()
                    Log.e("WEATHER_DATA_LOG", "Fetched Weather Data: ${weatherData.toString()}")
                    // If you want to update UI from here, you would need mutable state
                } catch (e: Exception) {
                    Log.e("WEATHER_DATA_LOG", "Error fetching weather: ${e.message}", e)
                    // Handle error, e.g., update UI to show an error message
                }
            }
        }
    }

}