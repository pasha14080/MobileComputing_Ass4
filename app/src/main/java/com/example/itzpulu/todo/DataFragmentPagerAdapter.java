package com.example.itzpulu.todo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by iTz Pulu on 11/9/2016.
 */
public  class DataFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Student> users;

    public DataFragmentPagerAdapter(FragmentManager fm, ArrayList<Student> usersList) {
        super(fm);
        this.users=usersList;
    }

    @Override
    public Fragment getItem(int index) {

        return PageFragment.newInstance(users.get(index));
    }

    @Override
    public int getCount() {

        return users.size();
    }
}
