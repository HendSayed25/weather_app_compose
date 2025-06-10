package com.example.weather_app_compose.data.remote.datasource

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.weather_app_compose.logic.entities.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationRemoteDataSourceImp(
    private val context: Context,
) : ILocationRemoteDataSource {

    private val fusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    override suspend fun getCurrentLocation(): Location =
        suspendCancellableCoroutine { continuation ->

            val permissionGranted = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

            if (!permissionGranted) {
                continuation.resumeWithException(
                    SecurityException("Location permission not granted")
                )
                return@suspendCancellableCoroutine
            }

            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        val result = Location(
                            latitude = location.latitude,
                            longitude = location.longitude
                        )
                        Log.d("Location", "Location fetched: $result")
                        continuation.resume(result)
                    } else {
                        continuation.resumeWithException(
                            Exception("Location is null")
                        )
                    }
                }
                .addOnFailureListener { e ->
                    continuation.resumeWithException(e)
                }
        }
}
