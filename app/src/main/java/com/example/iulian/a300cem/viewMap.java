package com.example.iulian.a300cem;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class viewMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);
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
        LatLng covCathedral = new LatLng(52.4082598, -1.5083808);
        LatLng transportMuseum = new LatLng(52.4103435, -1.5090892);
        LatLng belgradeTheatre = new LatLng(52.4095970, -1.5137288);
        LatLng millPark = new LatLng(52.4141588, -1.5186386);
        mMap.addMarker(new MarkerOptions().position(covCathedral).title("Coventry Cathedral").snippet("Lorem ipsum dolor sit amet, mel regione docendi complectitur eu, mea no mutat iudicabit tincidunt. Sale legendos sententiae qui cu."));
        mMap.addMarker(new MarkerOptions().position(transportMuseum).title("Transport Museum").snippet("Lorem ipsum dolor sit amet, mel regione docendi complectitur eu, mea no mutat iudicabit tincidunt. Sale legendos sententiae qui cu."));
        mMap.addMarker(new MarkerOptions().position(belgradeTheatre).title("Belgrade Theatre").snippet("Lorem ipsum dolor sit amet, mel regione docendi complectitur eu, mea no mutat iudicabit tincidunt. Sale legendos sententiae qui cu."));
        mMap.addMarker(new MarkerOptions().position(millPark).title("Naul's Mill Park").snippet("Lorem ipsum dolor sit amet, mel regione docendi complectitur eu, mea no mutat iudicabit tincidunt. Sale legendos sententiae qui cu."));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(covCathedral));
        //mMap.CameraUpdateFactory.zoomTo(float)
        mMap.setMinZoomPreference(15.0f);
    }
}
