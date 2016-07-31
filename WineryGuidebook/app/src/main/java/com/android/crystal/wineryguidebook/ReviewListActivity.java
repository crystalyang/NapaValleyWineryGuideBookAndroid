package com.android.crystal.wineryguidebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ReviewListActivity extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        id = i.getStringExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        // TODO add async task to get review list && add recycler view for displaying
//        getReviews task = new getWineries(getActivity(),id);
//        task.addListener(this);
//        task.execute();
        getReviews task = new getReviews(this,id);
        task.execute();

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

    public class getReviews  extends AsyncTask<String, String,  ArrayList<Review>> {
        private ProgressDialog dialog;
        private Context context;
//        private List<TaskListener> myListeners = new ArrayList<TaskListener>();
        private String wineryId;


//        public interface TaskListener{
//            public void onResultAvailable(ArrayList<Review> result);
//        }

//        public void addListener(TaskListener tl){
//            myListeners.add(tl);
//        }

        public getReviews(Activity context, String wineryId){
            this.context = context;
            this.wineryId = wineryId;
        }

        @Override
        protected void onPostExecute(ArrayList<Review> result) {
            super.onPostExecute(result);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
//            if(result!=null){
//
//                for(TaskListener tl : myListeners){
//                    tl.onResultAvailable(result);
//                }
//                myListeners.clear();
//            }

        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setCancelable(false);
            dialog.setMessage("Getting reviews..");
            dialog.isIndeterminate();
            dialog.show();

        }
        @Override
        protected ArrayList<Review> doInBackground(String... arg0) {
            ReviewService service = new ReviewService();
            ArrayList<Review> ReviewList = service.getReviews(wineryId);

            return ReviewList;
        }

    }

}

