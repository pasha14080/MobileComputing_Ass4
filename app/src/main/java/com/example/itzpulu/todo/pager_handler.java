package com.example.itzpulu.todo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iTz Pulu on 11/9/2016.
 */
public class pager_handler extends AppCompatActivity {

    private static final int NUMBER_OF_PAGES = 10;

    private ViewPager mViewPager;
    private DataFragmentPagerAdapter mMyFragmentPagerAdapter;

    ArrayList<Student> contactsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        contactsList = new ArrayList<Student>();
        prepareData();
        mMyFragmentPagerAdapter = new DataFragmentPagerAdapter(
                getSupportFragmentManager(), contactsList);
        mViewPager.setAdapter(mMyFragmentPagerAdapter);
    }
    public void prepareData()
    {
        DataBaseHandler db = new DataBaseHandler(pager_handler.this);
        List<Student> s = db.getStudents();
        for(Student st : s)
        {
            contactsList.add(new Student(st.getdescription(),st.getTitle()));
            Log.d("LOLOLOL",st.getdescription()+st.getTitle());
        }
    }
}
