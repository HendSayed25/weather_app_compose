package com.example.weather_app_compose.data.remote.datasource

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.weather_app_compose.data.remote.response.WeatherResponse
import com.example.weather_app_compose.logic.entities.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.json.Json
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationRemoteDataSourceImp(
    private val context: Context
) : ILocationRemoteDataSource{

    private val fusedLocationProvider = LocationServices.getFusedLocationProviderClient(context)

    override suspend fun getCurrentLocation(): Location  =
        suspendCancellableCoroutine { cont ->

            val permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            )

            if (permission != PackageManager.PERMISSION_GRANTED) {
                cont.resumeWithException(SecurityException("Location permission not granted"))
                return@suspendCancellableCoroutine
            }

            fusedLocationProvider.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        cont.resume(
                            Location(
                                latitude = location.latitude,
                                longitude = location.longitude
                            )
                        )
                        Log.e("Location",
                           location.toString()
                        )
                    } else {
                        cont.resumeWithException(Exception("Location is null"))
                    }
                }
                .addOnFailureListener { e ->
                    cont.resumeWithException(e)
                }
    }

}