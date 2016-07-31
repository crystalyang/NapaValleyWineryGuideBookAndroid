package com.android.crystal.wineryguidebook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements getWineries.TaskListener {
    private static View rootView;
    private final String TAG = getClass().getSimpleName();
    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewAdapter mAdapter;
    private int Size;
    private ArrayList<Winery> wineryList = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        rootView.setTag(TAG);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);


        if(wineryList.size() <= 0 ) {
            getWineries task = new getWineries(getActivity());
            task.addListener(this);
            task.execute();
        }else{
            setDataList(wineryList);
        }
    }

    @Override
    public void onResultAvailable(ArrayList<Winery> result){
        setDataList(result);
    }

    public void setDataList(ArrayList<Winery> result){
        wineryList = result;
        Size = result.size();
        mAdapter = new RecyclerViewAdapter(wineryList,Size);
        mRecyclerView.setAdapter(mAdapter);
    }


}
