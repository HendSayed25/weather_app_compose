package com.example.weather_app_compose

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.weather_app_compose.presentaion.WeatherScreen
import com.example.weather_app_compose.presentaion.viewmodels.WeatherViewModel
import com.example.weather_app_compose.ui.theme.Weather_app_composeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Start the permission check process
        checkLocationPermissionsAndProceed()

        setContent {
            val isDay by weatherViewModel.isDay.collectAsState(initial = 1)

            Weather_app_composeTheme(darkTheme = (isDay==0)) {
                WeatherScreen()
            }
        }
    }


    private fun checkLocationPermissionsAndProceed() {
        val fineLocationGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val coarseLocationGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (fineLocationGranted || coarseLocationGranted) {
            Log.d("MainActivity", "Location permission already granted. Fetching weather.")
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

}