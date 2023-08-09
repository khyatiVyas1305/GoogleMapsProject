package com.example.googlemapsproject

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.provider.SettingsSlicesContract.KEY_LOCATION
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import com.android.volley.BuildConfig
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.net.PlacesClient


class GoogleMapFragment : Fragment(), OnMapReadyCallback {

    private val locationPermissionCode = 123
    var mapFragment : SupportMapFragment?=null

    private var map: GoogleMap? = null
    private var cameraPosition: CameraPosition? = null

    // The entry point to the Places API.
    private lateinit var placesClient: PlacesClient

    // The entry point to the Fused Location Provider.
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    // A default location (Toronto, Canada) and default zoom to use when location permission is
    // not granted.
    private val defaultLocation = LatLng(43.6532, 79.3832)
    private var locationPermissionGranted = false

    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private var lastKnownLocation: Location? = null
    private var likelyPlaceNames: Array<String?> = arrayOfNulls(0)
    private var likelyPlaceAddresses: Array<String?> = arrayOfNulls(0)
    private var likelyPlaceAttributions: Array<List<*>?> = arrayOfNulls(0)
    private var likelyPlaceLatLngs: Array<LatLng?> = arrayOfNulls(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onMapReady(map: GoogleMap) {

        //googleMap = map
        val toronto = LatLng(43.6532, 79.3832)
        map.addMarker(
            MarkerOptions()
                .position(toronto)
                .title("Marker in Toronto")
        )
        // [START_EXCLUDE silent]
        map.moveCamera(CameraUpdateFactory.newLatLng(toronto))
        // Customize and work with the GoogleMap object here
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_google_map, container, false)
        mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}
