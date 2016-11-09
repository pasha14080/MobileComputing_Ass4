package com.example.itzpulu.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by iTz Pulu on 11/9/2016.
 */
public class PageFragment extends Fragment {

    public static PageFragment newInstance(Student singleStudent) {

        PageFragment pageFragment = new PageFragment();
        Bundle bundle = new Bundle();
      /*  bundle.putString("name", singleStudent.getName());
        bundle.putString("phone", singleStudent.getPhone());
        pageFragment.setArguments(bundle);*/

        bundle.putSerializable("Student", singleStudent);
        pageFragment.setArguments(bundle);

        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pager, container, false);
        final TextView textView1 = (TextView) view.findViewById(R.id.Pager_t);
        final TextView textView2 = (TextView) view.findViewById(R.id.Pager_d);

        Student cont= (Student) getArguments().getSerializable("Student");

        textView1.setText(cont.getdescription());
        textView2.setText(cont.getTitle());

        return view;
    }
} 