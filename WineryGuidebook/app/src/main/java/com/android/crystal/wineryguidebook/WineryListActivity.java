//package com.android.crystal.wineryguidebook;
//
//import android.content.pm.PackageManager;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.content.Intent;
//import android.support.v4.app.NavUtils;
//import android.view.MenuItem;
//import android.view.Menu;
//import android.view.View;
//import android.net.Uri;
//
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//
//
//public class WineryListActivity extends AppCompatActivity {
//
//
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_winery_list);
//
//
//
//        //to do: get extra to query db maybe not string
////        Bundle extras = getIntent().getExtras();
////        if(extras !=null){
////            String location =extras.getString("location");
////        }
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    //add menu bar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_action_bar, menu);
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
//                startActivity(new Intent(this, MainActivity.class)); //back to main activity
//                return true;
//            case R.id.action_add:
//                //startActivity(new Intent(this,AddReviewActivity.class)); //to do: create AddReviewAcitivity
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    //to do below will be moved to fragment list
//
//    //to do this will be changed to list item listener later
//    public void onClickRevList(View view) {
//        //get iteam id (winery id) to query the db for this typical winery reviews
//        Intent i = new Intent(this, ReviewListActivity.class);
//        i.putExtra("isMyRev", false);
//        startActivity(i);
//    }
//
//    //bug here
//    public void onClickDial(View view) {
//        //later
//        //get the phone number here
//
//
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse("tel:8453673308"));
//        //startActivity(callIntent);
//
//
//
//    }
//
//    public void onClickMap(View view) {
//        //get location info here
//        Intent i = new Intent(this, WineryMapActivity.class);
//        //put geo location info here
//        //i.putextra();
//        startActivity(i);
//    }
//
//
//    //以下不知道发生了什么....later fix
////
////
////    @Override
////    public void onStart() {
////        super.onStart();
////
////        // ATTENTION: This was auto-generated to implement the App Indexing API.
////        // See https://g.co/AppIndexing/AndroidStudio for more information.
////        client.connect();
////        Action viewAction = Action.newAction(
////                Action.TYPE_VIEW, // TODO: choose an action type.
////                "WineryList Page", // TODO: Define a title for the content shown.
////                // TODO: If you have web page content that matches this app activity's content,
////                // make sure this auto-generated web page URL is correct.
////                // Otherwise, set the URL to null.
////                Uri.parse("http://host/path"),
////                // TODO: Make sure this auto-generated app URL is correct.
////                Uri.parse("android-app://com.android.crystal.wineryguidebook/http/host/path")
////        );
////        AppIndex.AppIndexApi.start(client, viewAction);
////    }
////
////    @Override
////    public void onStop() {
////        super.onStop();
////
////        // ATTENTION: This was auto-generated to implement the App Indexing API.
////        // See https://g.co/AppIndexing/AndroidStudio for more information.
////        Action viewAction = Action.newAction(
////                Action.TYPE_VIEW, // TODO: choose an action type.
////                "WineryList Page", // TODO: Define a title for the content shown.
////                // TODO: If you have web page content that matches this app activity's content,
////                // make sure this auto-generated web page URL is correct.
////                // Otherwise, set the URL to null.
////                Uri.parse("http://host/path"),
////                // TODO: Make sure this auto-generated app URL is correct.
////                Uri.parse("android-app://com.android.crystal.wineryguidebook/http/host/path")
////        );
////        AppIndex.AppIndexApi.end(client, viewAction);
////        client.disconnect();
////    }
//}
