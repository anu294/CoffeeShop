package com.example.coffeeshop.ui.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coffeeshop.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationFragment extends Fragment {

    private LocationViewModel locationViewModel;
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        locationViewModel =
//                ViewModelProviders.of(this).get(LocationViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_location, container, false);
//        final TextView textView = root.findViewById(R.id.text_location);
//        locationViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
//        mapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap mMap) {
//
//                // Add a marker in Sydney and move the camera
//                LatLng sydney = new LatLng(-20.501415, -11.057528);
//                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//            }
//        });

//        return root;
        mView = inflater.inflate(R.layout.fragment_location, container, false);
        return mView;
    }
//    @Override
//    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
//        super.onViewCreated(view, savedInstanceState);
//
//        mMapView = (MapView) mView.findViewById(R.id.map);
//        if(mMapView!=null){
//            mMapView.onCreate(null);
//            mMapView.onResume();
//            mMapView.getMapAsync(new OnMapReadyCallback() {
//                @Override
//                public void onMapReady(GoogleMap mMap) {
//
//                    // Add a marker in Sydney and move the camera
//                    LatLng sydney = new LatLng(-20.501415, -11.057528);
//                    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//                }
//            });
//        }
//    }
}