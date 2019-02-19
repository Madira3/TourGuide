package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VisitListFrag extends android.app.Fragment {


    public VisitListFrag() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.list_item, container,false);
       Activity activity = getActivity();

       final ArrayList<List> visitList = new ArrayList<>();

       visitList.add(new List(getString(R.string.museum),R.drawable.museum));
       visitList.add(new List(getString(R.string.golf), R.drawable.golf));
       visitList.add(new List(getString(R.string.park),R.drawable.fryingpanfarm));
       visitList.add(new List(getString(R.string.depot),R.drawable.herndon_depot));

       ListAdapter visitListAdapter = new ListAdapter(getActivity(), visitList);

        ListView visitListView = rootView.findViewById(R.id.list);

        visitListView.setAdapter(visitListAdapter);

        visitListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MuseumFragment(),"museumTag").addToBackStack(null).commit();


                }

                else if(position == 1){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new GolfFragment()).addToBackStack(null).commit();


                }

                else if(position == 2){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FarmParkFragment()).addToBackStack(null).commit();

                }

                else{
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HerndonDepotFragment()).addToBackStack(null).commit();

                }

            }
        });




       return rootView;
    }
}
