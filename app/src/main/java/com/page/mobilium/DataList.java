package com.page.mobilium;


import java.io.Serializable;

/**
 * Created by Administrator on 2015/1/18.
 */
public class DataList implements Serializable {

    String image;
    String title;
    String description;

    public DataList(String image, String title, String des){
        this.image = image;
        this.title = title;
        this.description = des;
    }

    public String getImage(){
        return this.image;
    }

    // setting id
    public void setImage(String image){
        this.image = image;
    }

    // getting name
    public String getTitle(){
        return this.title;
    }

    // setting name
    public void setTitle(String title){
        this.title = title;
    }

    // getting phone number
    public String getDes(){
        return this.description;
    }

    // setting phone number
    public void setDes(String description){
        this.description = description;
    }


}
