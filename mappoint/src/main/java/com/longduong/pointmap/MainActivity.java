package com.longduong.pointmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback , GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {


    public String strLong;
    public String strLat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText eInput=(EditText)findViewById(R.id.txtInput);
        String strInput=eInput.getText().toString();
        String str[]=strInput.split(" ");
        strLong=str[0];
        strLat=str[1];
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapview);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(Double.parseDouble(strLong), Double.parseDouble(strLat));
        //map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
        map.setOnMapClickListener(this);

    }
    @Override
    public void onMapClick(LatLng point) {
        Toast.makeText(getApplicationContext(),"tapped, point=" + point,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapLongClick(LatLng point) {
        Toast.makeText(getApplicationContext(),"long pressed, point=" + point,Toast.LENGTH_LONG).show();
    }
}
