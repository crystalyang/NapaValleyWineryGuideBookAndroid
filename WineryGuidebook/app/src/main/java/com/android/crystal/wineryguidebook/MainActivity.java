package com.android.crystal.wineryguidebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Winery> WineryList;
    private final String TAG = getClass().getSimpleName();
    private LatLng currentLoc = new LatLng(38.2891543, -122.3763611);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getWineries(this, "").execute();

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
                System.out.print(place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }

//    //add menu bar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_action_bar,menu);
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



    private class getWineries extends AsyncTask<String, String,  ArrayList<Winery>> {
        private ProgressDialog dialog;
        private Context context;
        private String cafes;

        public getWineries(Activity context, String cafes){
            this.context = context;
            this.cafes = cafes;
        }

        @Override
        protected void onPostExecute(ArrayList<Winery> result) {
            super.onPostExecute(result);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
//            cafesList = result;
//            Size = result.size();
//
//            mAdapter = new RecyclerViewAdapter(cafesList,Size);
//            mRecyclerView.setAdapter(mAdapter);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setCancelable(false);
            dialog.setMessage("Loading..");
            dialog.isIndeterminate();
            dialog.show();

        }
        @Override
        protected ArrayList<Winery> doInBackground(String... arg0) {
            WineryService service = new WineryService();
            ArrayList<Winery> WineryList = service.findWineries(currentLoc.latitude, currentLoc.longitude, "cafe");

            return WineryList;
        }
    }

    public void onClickList(View view){
        //to do: add code for getting current location http://stackoverflow.com/questions/17591147/how-to-get-current-location-in-android

        Intent i = new Intent(this, WineryListActivity.class);
        //i.putExtra(); //add location info for db query
        startActivity(i);
    }

    public void onClickMyAccount(View view){
        Intent i = new Intent(this, MyAccountActivity.class);
        startActivity(i);
    }




}
