package com.example.dana.muzej.Helpers;

import java.io.Serializable;

import static android.R.attr.name;

public class Image implements Serializable {


    public String name_bih;
    public String name_eng;
    public  String image1;
    public String Description_eng;
    public String Description_bih;

    public Image(String imageUrl, String name_bih,String name_eng, String Description_eng,String Description_bih ){
        this.image1=imageUrl;
        this.name_bih=name_bih;
        this.name_eng=name_eng;
        this.Description_bih=Description_bih;
        this.Description_eng=Description_eng;
    }

    public Image() {
        image1 = null;
        name_bih = null;
        name_eng=null;
        Description_bih = null;
        Description_eng = null;
    }
}

