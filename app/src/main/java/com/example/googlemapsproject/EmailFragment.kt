package com.example.googlemapsproject

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng


lateinit var emailED: EditText
lateinit var sendBtn: Button
lateinit var latLon: String

class EmailFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailED = view.findViewById(R.id.emailED)
        sendBtn = view.findViewById(R.id.sendBtn)
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(requireContext() as Activity,arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100)
            return
        }
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                var latLng = LatLng(location.latitude, location.longitude)
                // Use the latLng for your map operations
                latLon = latLng.toString()
            }
        }

        sendBtn.setOnClickListener {
            val email = emailED.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,email)
                //getLocation()
                putExtra(Intent.EXTRA_TEXT, latLon)

            }
            startActivity(intent)
        }
    }

    private fun getLocation(){

    }
}