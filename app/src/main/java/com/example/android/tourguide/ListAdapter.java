package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<List> {

    public ListAdapter(Activity context, ArrayList<List> visitList){
        super(context,0,visitList);
    }

    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.visit_fragment, parent, false);
        }
        List currentPlace = getItem(position);

        TextView placeTextView =  listItemView.findViewById(R.id.place_text);
        placeTextView.setText(currentPlace.getmPlace());

        ImageView placeImageView = listItemView.findViewById(R.id.place_image);
        placeImageView.setImageResource(currentPlace.getmImageId());

        return listItemView;
    }
}
