//package com.android.crystal.wineryguidebook;
//
//import android.content.Intent;
//import android.support.v4.app.NavUtils;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.RemoteViews;
//
//public class MyAccountActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_account);
//    }
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
//    public void onClickMyRev(View view){
//        Intent i = new Intent(this, ReviewListActivity.class);
//        //add param for db query just for my reviews
//        i.putExtra("isMyRev",true);
//        startActivity(i);
//    }
//
//    public void onClickMyFav(View view){
//        Intent i = new Intent(this, WineryListActivity.class);
//        //i.putExtra(); //add param for db query just for my fav wineries
//        startActivity(i);
//    }
//
//
//
//
//
//}
