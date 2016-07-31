//package com.android.crystal.wineryguidebook;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.AsyncTask;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Crystal on 7/30/16.
// */
//public class getReviews  extends AsyncTask<String, String,  ArrayList<Review>> {
//    private ProgressDialog dialog;
//    private Context context;
//    private List<TaskListener> myListeners = new ArrayList<TaskListener>();
//    private String wineryId;
//
//
//    public interface TaskListener{
//        public void onResultAvailable(ArrayList<Review> result);
//    }
//
//    public void addListener(TaskListener tl){
//        myListeners.add(tl);
//    }
//
//    public getReviews(Activity context,String wineryId){
//        this.context = context;
//        this.wineryId = wineryId;
//    }
//
//    @Override
//    protected void onPostExecute(ArrayList<Review> result) {
//        super.onPostExecute(result);
//        if (dialog.isShowing()) {
//            dialog.dismiss();
//        }
//        if(result!=null){
//
//            for(TaskListener tl : myListeners){
//                tl.onResultAvailable(result);
//            }
//            myListeners.clear();
//        }
//
//    }
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        dialog = new ProgressDialog(context);
//        dialog.setCancelable(false);
//        dialog.setMessage("Getting reviews..");
//        dialog.isIndeterminate();
//        dialog.show();
//
//    }
//    @Override
//    protected ArrayList<Review> doInBackground(String... arg0) {
//        ReviewService service = new ReviewService();
//        ArrayList<Review> ReviewList = service.getReviews(wineryId);
//
//        return ReviewList;
//    }
//
//}
