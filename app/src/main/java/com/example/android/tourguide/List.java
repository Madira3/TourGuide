package com.example.android.tourguide;

public class List {
    private String mPlace;
    private int mImageId;

    public List(String place, int imageId){
        mPlace = place;
        mImageId = imageId;
    }

    public String getmPlace(){
        return mPlace;
    }

    public int getmImageId(){
        return mImageId;
    }

}
