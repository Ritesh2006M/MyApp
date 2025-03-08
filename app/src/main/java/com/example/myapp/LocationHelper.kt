package com.example.myapp

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class LocationHelper(private val context: Context) {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    // Fetches the current location
    fun getCurrentLocation(onLocationReceived: (Location?) -> Unit) {
        // Check if the location permission is granted
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                onLocationReceived(location)
            }
        } else {
            // Handle the case where permission is not granted
            onLocationReceived(null)
        }
    }

    // Get the address from coordinates (latitude and longitude)
    fun getAddressFromCoordinates(latitude: Double, longitude: Double): String {
        val geocoder = Geocoder(context, Locale.getDefault())
        try {
            val addressList = geocoder.getFromLocation(latitude, longitude, 1)
            return if (addressList != null && addressList.isNotEmpty()) {
                addressList[0].getAddressLine(0) ?: "Address not found"
            } else {
                "Address not found"
            }
        } catch (e: Exception) {
            // Handle any exceptions (e.g., network issues, Geocoder failure)
            return "Unable to fetch address"
        }
    }
}
