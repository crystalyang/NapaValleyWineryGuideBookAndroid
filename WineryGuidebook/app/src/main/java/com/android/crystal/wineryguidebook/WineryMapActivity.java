//package com.android.crystal.wineryguidebook;
//
//import android.content.Intent;
//import android.support.v4.app.FragmentActivity;
//import android.os.Bundle;
//import android.support.v4.app.NavUtils;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class WineryMapActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//
//
//
//    // 暂时不work later fix
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_winery_map);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
//
//
//    //add menu bar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_action_bar,menu);
//        //hide add review item for this activity
//        MenuItem item = menu.findItem(R.id.action_add);
//        item.setVisible(false);
//        this.invalidateOptionsMenu();
//        return true;
//    }
//
//    //menu bar item selection
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            case R.id.action_back:
//                startActivity(new Intent(this,MainActivity.class)); //back to main activity
//                return true;
//            case R.id.action_add:
//                //startActivity(new Intent(this,AddReviewActivity.class)); //to do: create AddReviewAcitivity
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//
//}
