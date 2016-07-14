package com.android.crystal.wineryguidebook;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AddReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBHandler dbHandler;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        dbHandler = new DBHandler(this, null, null, 1);
    }

    //add menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action_bar,menu);
        //hide add review item for this activity
        MenuItem item = menu.findItem(R.id.action_add);
        item.setVisible(false);
        this.invalidateOptionsMenu();
        return true;
    }

    //menu bar item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_back:
                startActivity(new Intent(this,MainActivity.class)); //back to main activity
                return true;
            case R.id.action_add:
                //startActivity(new Intent(this,AddReviewActivity.class)); //to do: create AddReviewAcitivity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickSaveRev(View view){
        // to do: call dbHandler to query the db insert a record.
        Intent i = new Intent(this, ReviewListActivity.class);
        //i.putExtra(); //add param for db query just for my reviews
        startActivity(i);
    }





}
