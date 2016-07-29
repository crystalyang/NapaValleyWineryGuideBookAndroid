package com.android.crystal.wineryguidebook;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Winery> wineryList;
    Bundle bundle;

    final int PAGE_COUNT = 2;
    // Tab Titles
    private String tabtitles[] = new String[] { "Map", "List"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
//        this.bundle = list;
//
    }

    //@Override
    public int getCount() {
        return PAGE_COUNT;
    }

    //@Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                MapFragment fragmenttab1 = new MapFragment();
                return fragmenttab1;

            case 1:
                ListFragment fragmenttab2 = new ListFragment();
                return fragmenttab2;

//            case 2:
//                ListFragment fragmenttab3 = new ListFragment();
//                return fragmenttab3;

        }
        return null;
    }

    // @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }


}
