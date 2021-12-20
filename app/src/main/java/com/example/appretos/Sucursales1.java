package com.example.appretos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class Sucursales1 extends AppCompatActivity implements OnMapReadyCallback {

    private ActionBar actionBar;
    private static int FROM_REQUEST_CODE = 1;
    private static int TO_REQUEST_CODE = 2;
    private static String TAG = "Sucursales";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales1);

        // Initialize the SDK
        Places.initialize(getApplicationContext(), getString(R.string.apikey));
        //buttom to map
        Button btnFrom= findViewById(R.id.btnFrom);
        btnFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autocompleFrom();
            }
        });

        Button btnTo= findViewById(R.id.btnTo);
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autocompleTo();
            }
        });

        //Map support
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    private void autocompleFrom(){
        // Places autocpmplete
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, FROM_REQUEST_CODE);

    }
    private void autocompleTo(){
        // Places autocpmplete
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, TO_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == FROM_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            } else if (resultCode == TO_REQUEST_CODE) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }
   /*
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos) {
            Intent intent = new Intent(getApplicationContext(), Productos.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Productos", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (id == R.id.servicios) {
            Intent intent = new Intent(getApplicationContext(), Servicios.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Servicios", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (id == R.id.sucursales) {
            Intent intent = new Intent(getApplicationContext(), Sucursales.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Sucursales", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (id == R.id.sucursales1) {
          Intent intent = new Intent(getApplicationContext(), Sucursales.class);
           Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Sucursales", Toast.LENGTH_LONG).show();
           startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Colombia and move the camera
        LatLng sedeA = new LatLng(4.60971,-74.08175);
        mMap.addMarker(new MarkerOptions().position(sedeA).title("Local autopartes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sedeA));

        LatLng sedeB = new LatLng(4.81333, -75.69611);
        mMap.addMarker(new MarkerOptions().position(sedeB).title("Local autopartes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sedeB));

        LatLng sedeC = new LatLng(11.24079, -74.19904);
        mMap.addMarker(new MarkerOptions().position(sedeC).title("Local autopartes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sedeC));

    }

}