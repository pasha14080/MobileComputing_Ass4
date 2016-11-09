package com.example.itzpulu.todo;

/**
 * Created by iTz Pulu on 11/9/2016.
 */

import java.io.Serializable;

/**
 * Created by iTz Pulu on 10/2/2016.
 */
public class Student implements Serializable {

    String Title,description;
    public Student(){}
    public Student(String description, String Title)
    {
        this.description=description;
        this.Title=Title;

    }
    public String getdescription()
    {
        return this.description;
    }

    public String getTitle(){
        return this.Title;
    }
    public void setdescription(String description)
    {
        this.description=description;
    }

    public void setTitle(String Title)
    {
        this.Title=Title;
    }
}
