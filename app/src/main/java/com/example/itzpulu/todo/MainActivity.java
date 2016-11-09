package com.example.itzpulu.todo;

import android.app.Dialog;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView RV;
    private StaggeredGridLayoutManager SG;
    private RecyclerViewAdapter RVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] pass = new String[100];
        DataBaseHandler db = new DataBaseHandler(MainActivity.this);
        List<Student> s = db.getStudents();
        int i= 0;
        for (Student st : s)
        {
            pass[i]= (st.getdescription());
            i++;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RV = (RecyclerView)findViewById(R.id.my_recycler_view);
        SG = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        RV.setItemAnimator(new DefaultItemAnimator());
        RV.setLayoutManager(SG);
        RVM = new RecyclerViewAdapter(getApplicationContext(), pass);
        RV.setAdapter(RVM);
    }
    public void Add_data(View V)
    {
        final Dialog login = new Dialog(this);
        // Set GUI of login screen
        login.setContentView(R.layout.add);
        login.setTitle("Enter the data");
        Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) login.findViewById(R.id.btnCancel);
        final EditText txtUsername = (EditText)login.findViewById(R.id.Title);
        final EditText txtPassword = (EditText)login.findViewById(R.id.Description);


        // Attached listener for login GUI button
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText().toString().trim().length() > 0 && txtPassword.getText().toString().trim().length() > 0)
                {
                    String[] pass = new String[100];
                    DataBaseHandler db = new DataBaseHandler(MainActivity.this);
                    db.addStudent(new Student((txtPassword.getText().toString()), txtUsername.getText().toString()));
                    Toast.makeText(MainActivity.this,"Data updated",Toast.LENGTH_LONG).show();
                    List<Student> s = db.getStudents();
                    int i = 0;
                    for (Student st : s)
                    {
                        pass[i] = (st.getdescription());
                        i++;
                    }

                    RV = (RecyclerView)findViewById(R.id.my_recycler_view);
                    SG = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                    RV.setItemAnimator(new DefaultItemAnimator());
                    RV.setLayoutManager(SG);
                    RVM = new RecyclerViewAdapter(getApplicationContext(), pass);
                    RV.setAdapter(RVM);
                    login.dismiss();
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Please enter Title and description correctly", Toast.LENGTH_LONG).show();

                }
            }
        });
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login.dismiss();
            }
        });

        // Make dialog box visible.
        login.show();
    }
}
