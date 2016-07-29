package com.android.crystal.wineryguidebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    public ArrayList<Winery> WineryList;
    private final String TAG = getClass().getSimpleName();
    private LatLng currentLoc = new LatLng(38.2891543, -122.3763611);
    ViewPager viewPager;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Locate the viewpager in activity_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

    }



//    public interface TaskListener{
//        public void onResultAvailable(ArrayList<Winery> result);
//    }
//
//
//    public class getWineries extends AsyncTask<String, String,  ArrayList<Winery>> {
//        private ProgressDialog dialog;
//        private Context context;
//        private List<TaskListener> myListeners = new ArrayList<TaskListener>();
//
//
//        public void addListener(TaskListener tl){
//            myListeners.add(tl);
//        }
//
//        public getWineries(Activity context){
//            this.context = context;
//
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<Winery> result) {
//            super.onPostExecute(result);
//            if (dialog.isShowing()) {
//                dialog.dismiss();
//            }
//            if(result!=null){
//
//                for(TaskListener tl : myListeners){
//                    tl.onResultAvailable(result);
//                }
//                myListeners.clear();
//            }
//
////            Bundle bundle = new Bundle();
////            bundle.putParcelableArrayList("WineryList", result);
////            viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()),bundle);
////            cafesList = result;
////            Size = result.size();
////
////            mAdapter = new RecyclerViewAdapter(cafesList,Size);
////            mRecyclerView.setAdapter(mAdapter);
//        }
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            dialog = new ProgressDialog(context);
//            dialog.setCancelable(false);
//            dialog.setMessage("Loading..");
//            dialog.isIndeterminate();
//            dialog.show();
//
//        }
//        @Override
//        protected ArrayList<Winery> doInBackground(String... arg0) {
//            WineryService service = new WineryService();
//            ArrayList<Winery> WineryList = service.findWineries(currentLoc.latitude, currentLoc.longitude, "cafe");
//
//            return WineryList;
//        }
//    }

}
