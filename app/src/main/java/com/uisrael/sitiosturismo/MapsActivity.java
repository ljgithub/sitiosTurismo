package com.uisrael.sitiosturismo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng UIsrael = new LatLng(-0.1443374, -78.5077754);
        mMap.addMarker(new MarkerOptions().position(UIsrael).title("UNIVERSIDAD Israel").icon(BitmapDescriptorFactory.fromResource(R.drawable.uisrael1)));

        LatLng palacio = new LatLng(1.126111, -78.762222);
        mMap.addMarker(new MarkerOptions().position(palacio).title("Palacio de Carondelet").icon(BitmapDescriptorFactory.fromResource(R.drawable.palacio1)));

        LatLng mMundo = new LatLng(1.2607022, -78.6098945);
        mMap.addMarker(new MarkerOptions().position(mMundo).title("Mitad del mundo").icon(BitmapDescriptorFactory.fromResource(R.drawable.mitadmundo1)));

        LatLng panecillo = new LatLng(1.6564003, -77.4614931);
        mMap.addMarker(new MarkerOptions().position(panecillo).title("El panecillo").icon(BitmapDescriptorFactory.fromResource(R.drawable.panecillo1)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UIsrael,13));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
