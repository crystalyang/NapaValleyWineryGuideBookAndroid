package com.android.crystal.wineryguidebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, getWineries.TaskListener {
    private final String TAG = getClass().getSimpleName();
    private GoogleMap mMapView;
    private SupportMapFragment fragment;
    private ArrayList<Winery> wineryList = new ArrayList<>();
    public static final int TYPE_POINT_OF_INTEREST = 1013;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RelativeLayout mRelativeLayout = (RelativeLayout) inflater.inflate(
                R.layout.fragment_map, container, false);


        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        List<Integer> filters = new ArrayList<Integer>();
        filters.add(Place.TYPE_POINT_OF_INTEREST);
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT)
                .build();
        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
//                Winery selected = new Winery();
//                selected.setId(place.getId());
//                selected.setRate(Float.toString(place.getRating()));
//                selected.setVicinity(place.getAddress().toString());
//                selected.setName(place.getName().toString());
//                selected.setPhone(place.getPhoneNumber().toString());
//                selected.setLongitude(place.getLatLng().longitude);
//                selected.setLatitude(place.getLatLng().latitude);

                Intent i = new Intent(getActivity(),WineryDetailActivity.class);
                i.putExtra("id",place.getId());
                i.putExtra("rate",Float.toString(place.getRating()));
                i.putExtra("name",place.getName());
                i.putExtra("address",place.getAddress());
                i.putExtra("phone", place.getPhoneNumber());
                startActivity(i);

                Log.i(TAG, "Place: " + place.getName());
                System.out.print(place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.

                Log.i(TAG, "An error occurred: " + status);
            }
        });

        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();
        }
        fragment.getMapAsync(this);

    return mRelativeLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);


        if(wineryList.size() <= 0 ) {
            getWineries task = new getWineries(getActivity());
            task.addListener(this);
            task.execute();
        }else{
            setDataList(wineryList);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapView = googleMap;
        LatLng current = new LatLng(37.3355457, -121.882949);
        mMapView.addMarker(new MarkerOptions().position(current).title("current location"));
        mMapView.moveCamera(CameraUpdateFactory.newLatLng(current));
    }

    @Override
    public void onResultAvailable(ArrayList<Winery> result){
        setDataList(result);
        }

    public void setDataList(ArrayList<Winery> result){
        wineryList = result;
        for (int i = 0; i < wineryList.size(); i++) {
            //String cafeName = wineryList.get(i).getName();

            mMapView.addMarker(new MarkerOptions()
                    .title(wineryList.get(i).getName())
                    .position(
                            new LatLng(wineryList.get(i).getLatitude(), wineryList
                                    .get(i).getLongitude()))
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.marker))
                    .snippet(wineryList.get(i).getVicinity()));
        }
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(result.get(0).getLatitude(), result
                        .get(0).getLongitude()))
                .zoom(14)
                .tilt(30)
                .build();
        mMapView.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }



}
