package com.example.ezyfoodyproject;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public String AMQuantity = "0", JAPQuantity = "0", JMQuantity = "0", JALQuantity = "0";
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    public String id;
    public String ia;
    public double lat=0, longitude=0;
    DatabaseHelper myDB;
    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    TextView alamat, jj,jt, m;
    TextView test;
    Location currentLocation;
    float[] results = new float[2];
    float d1,d2;
    double jarakjakrta=0,jaraktangerang=0;
    private static final int REQUEST_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        alamat = (TextView) findViewById(R.id.alamat);
        jj = (TextView) findViewById(R.id.jarakjakarta);
        jt = (TextView) findViewById(R.id.jaraktangerang);
        m = (TextView) findViewById(R.id.banding);
        AMQuantity = intent.getStringExtra("airMineral");
        JAPQuantity = intent.getStringExtra("jusApel");
        JMQuantity = intent.getStringExtra("jusMangga");
        JALQuantity = intent.getStringExtra("jusAlpukat");
        NGQuantity = intent.getStringExtra("nasiGoreng");
        BQuantity = intent.getStringExtra("batagor");
        MAQuantity = intent.getStringExtra("mieAyam");
        AGQuantity = intent.getStringExtra("ayamGoreng");
        LQuantity = intent.getStringExtra("lumpia");
        KGQuantity = intent.getStringExtra("kentangGoreng");
        ORQuantity = intent.getStringExtra("onionRing");
        RBQuantity = intent.getStringExtra("rotiBakar");
        id = intent.getStringExtra("id");
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();
    }

    public void getLocation()
    {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location=task.getResult();
                if(location!=null)
                {
                    currentLocation =location;
                    Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
                    try {
                        List<Address> address= geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        alamat.setText("Delivered to your location at:\n"+ address.get(0).getAddressLine(0));
                        ia=address.get(0).getAddressLine(0);
                        lat=address.get(0).getLatitude();
                        longitude=address.get(0).getLongitude();
                        SupportMapFragment supportMapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                        supportMapFragment.getMapAsync(MapsActivity.this::onMapReady);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
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
        LatLng sydney = new LatLng(-6.2, 106.81);
        mMap.addMarker(new MarkerOptions().position(sydney).title("EzyFoody Jakarta"));

        LatLng tangerang = new LatLng(-6.1702, 106.6403);
        mMap.addMarker(new MarkerOptions().position(tangerang).title("EzyFoody Tangerang"));

        if(lat!=0||longitude!=0)
        {
            Location.distanceBetween(lat,longitude, -6.2, 106.81, results);
            jt.setText(String.format("%.2f",results[0]/1000)+" KM from your location");
            d1=results[0];
            Location.distanceBetween(lat,longitude, -6.1702, 106.6403, results);
            jj.setText(String.format("%.2f",results[0]/1000)+" KM from your location");
            d2=results[0];
            if(d1==d2)
            {
                m.setText("Both restaurant have same distance to your location");
            }
            else if(d1<d2)
            {
                m.setText("EzyFoody Jakarta is nearer to your location");
            }
            else
            {
                m.setText("EzyFoody Tangerang is nearer to your location");
            }
            LatLng cur = new LatLng(lat, longitude);
            mMap.addMarker(new MarkerOptions().position(cur).title("Your position"));
            CameraPosition myPosition = new CameraPosition.Builder()
                    .target(cur).zoom(10).build();
            googleMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(myPosition));
        }
    }


    public void onClickAlam(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", "1");
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }

    public void onClickKemanggisan(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", "2");
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }

}