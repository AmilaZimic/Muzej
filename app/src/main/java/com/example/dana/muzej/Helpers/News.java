package com.example.dana.muzej.Helpers;

import java.io.Serializable;

public class News implements Serializable {


    public String event_name_bih;
    public String event_name_eng;
    public  String event_image;
    public String event_desc_bih;
    public String event_desc_eng;

    public News(String imageUrl, String event_name_bih, String event_name_eng,  String event_desc_bih, String event_desc_eng){
       this.event_image=imageUrl;
        this.event_name_bih=event_name_bih;
        this.event_name_eng=event_name_eng;
        this.event_desc_bih=event_desc_bih;
        this.event_desc_eng=event_desc_eng;
    }

    public News() {
        event_name_bih=null;
        event_name_eng=null;
        event_image=null;
        event_desc_bih=null;
        event_desc_eng=null;
    }
}

