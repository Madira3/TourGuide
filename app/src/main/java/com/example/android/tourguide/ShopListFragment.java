package com.example.android.tourguide;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopListFragment extends android.app.Fragment {


    public ShopListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container,false);
        Activity activity = getActivity();

        final ArrayList<List> shopList = new ArrayList<>();

        shopList.add(new List(getString(R.string.village_center),R.drawable.village_center));
        shopList.add(new List(getString(R.string.worldgate), R.drawable.worldgate));
        shopList.add(new List(getString(R.string.woodland),R.drawable.woodland));

        ListAdapter shopListAdapter = new ListAdapter(getActivity(), shopList);

        ListView shopListView = rootView.findViewById(R.id.list);

        shopListView.setAdapter(shopListAdapter);

        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new VillageCenter()).addToBackStack(null).commit();


                }

                else if(position == 1){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorldGateFragment()).addToBackStack(null).commit();


                }

                else if(position == 2){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new WoodlandFragment()).addToBackStack(null).commit();

                }

            }
        });




        return rootView;
    }
}
