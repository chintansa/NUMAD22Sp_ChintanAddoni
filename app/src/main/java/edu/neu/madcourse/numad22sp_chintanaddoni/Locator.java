package edu.neu.madcourse.numad22sp_chintanaddoni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import android.os.Bundle;

public class Locator extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView latitudeValue;
    TextView longitudeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locator);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        latitudeValue = findViewById(R.id.latitude);
        longitudeValue = findViewById(R.id.longitude);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            return;
        }
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latitudeValue.setText("Latitude:     " + location.getLatitude());
                longitudeValue.setText("Longitude:  " + location.getLongitude());
            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(Locator.this, "Access Granted", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1, this);
            } else {
                Toast.makeText(Locator.this, "Access Denied!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeValue.setText("Latitude:     " + location.getLatitude());
        longitudeValue.setText("Longitude:  " + location.getLongitude());
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("GPS","Disabled");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("GPS","Enabled");
    }
}