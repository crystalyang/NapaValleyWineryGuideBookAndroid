package com.android.crystal.wineryguidebook;

/**
 * Created by Crystal on 7/29/16.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Winery> wineryList;
    private int Size;

    public RecyclerViewAdapter(ArrayList<Winery> itemsData, int size) {
        Collections.sort(itemsData,new Winery());
        ArrayList<Winery> list = new ArrayList<Winery>();
        for(int i=itemsData.size()-1 ; i!=0; i--){

            list.add(itemsData.get(i));
        }

        this.wineryList = list;
        this.Size = size;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(wineryList.get(position).getName());
        viewHolder.txtViewRate.setText(wineryList.get(position).getRate().toString());
        viewHolder.txtViewAdd.setText(wineryList.get(position).getVicinity());


    }


    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public TextView txtViewRate;
        public TextView txtViewAdd;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            txtViewRate = (TextView) itemLayoutView.findViewById(R.id.item_rate);
            txtViewAdd = (TextView) itemLayoutView.findViewById(R.id.item_address);
        }
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Size;
    }




}
