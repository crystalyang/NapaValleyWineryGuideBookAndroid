package com.android.crystal.wineryguidebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
