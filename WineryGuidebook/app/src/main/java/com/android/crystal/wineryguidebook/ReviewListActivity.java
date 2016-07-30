package com.android.crystal.wineryguidebook;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ReviewListActivity extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        id = i.getStringExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        // TODO add async task to get review list && add recycler view for displaying
    }

    //add menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action_bar,menu);
//        if(isMyRev) {
//            MenuItem item = menu.findItem(R.id.action_add);
//            item.setVisible(false);
//            this.invalidateOptionsMenu();
//        }
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
//            case R.id.action_add:
//                startActivity(new Intent(this,AddReviewActivity.class)); //to do: create AddReviewAcitivity
//                //i.putExtra(); to do add winery id here
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
