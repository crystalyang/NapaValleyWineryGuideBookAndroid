package com.android.crystal.wineryguidebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ReviewListActivity extends Activity {
    String id;
    private final String TAG = getClass().getSimpleName();
    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    private ReviewRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        id = i.getStringExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        mRecyclerView = (RecyclerView) this.findViewById(R.id.reviewRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        getReviews task = new getReviews(this,id);
        task.execute();
    }

    //add menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action_bar,menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

    public class getReviews  extends AsyncTask<String, String,  ArrayList<Review>> {
        private ProgressDialog dialog;
        private Context context;
        private String wineryId;

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
            if(result.size()>0){
                mAdapter = new ReviewRecyclerViewAdapter(result,result.size());
                mRecyclerView.setAdapter(mAdapter);
            }
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

