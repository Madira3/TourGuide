package com.example.android.tourguide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class DineListFrag extends Fragment {

    public DineListFrag() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container,false);
        Activity activity = getActivity();

        final ArrayList<List> dineList = new ArrayList<>();

        dineList.add(new List(getString(R.string.stones),R.drawable.stones_cove));
        dineList.add(new List(getString(R.string.bagel), R.drawable.bagel_cafe));
        dineList.add(new List(getString(R.string.houlihan),R.drawable.houlihans));
        dineList.add(new List(getString(R.string.jimmy),R.drawable.jimmys));

        ListAdapter dineListAdapter = new ListAdapter(getActivity(), dineList);

        ListView dineListView = rootView.findViewById(R.id.list);

        dineListView.setAdapter(dineListAdapter);

        dineListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoneFragment(),null).addToBackStack(null).commit();


                }

                else if(position == 1){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BagelFragment()).addToBackStack(null).commit();


                }

                else if(position == 2){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoulihanFragment()).addToBackStack(null).commit();

                }

                else{
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new JimmyFragment()).addToBackStack(null).commit();

                }

            }
        });




        return rootView;
    }
}