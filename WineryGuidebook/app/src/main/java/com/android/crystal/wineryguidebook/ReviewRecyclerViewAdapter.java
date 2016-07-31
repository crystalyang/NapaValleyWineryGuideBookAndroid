package com.android.crystal.wineryguidebook;

import android.support.v4.app.RemoteInput;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crystal on 7/30/16.
 */
public class ReviewRecyclerViewAdapter extends  RecyclerView.Adapter<ReviewRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Review> reviewList;
    private int Size;

    public ReviewRecyclerViewAdapter(ArrayList<Review> itemsData, int size) {
      //  Collections.sort(itemsData,new Review());
//        ArrayList<Review> list = new ArrayList<Review>();
//        for(int i=itemsData.size()-1 ; i!=0; i--){
//
//            list.add(itemsData.get(i));
//        }

        this.reviewList = itemsData;
        this.Size = size;
    }

    @Override
    public ReviewRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewAuthor.setText(reviewList.get(position).getAuthorName());
        viewHolder.txtViewRate.setText(reviewList.get(position).getRate());
        viewHolder.txtViewText.setText(reviewList.get(position).getText());


    }


    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewAuthor;
        public TextView txtViewRate;
        public TextView txtViewText;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewAuthor = (TextView) itemLayoutView.findViewById(R.id.review_item_author);
            txtViewRate = (TextView) itemLayoutView.findViewById(R.id.review_item_rate);
            txtViewText = (TextView) itemLayoutView.findViewById(R.id.review_item_text);
        }
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Size;
    }




}
