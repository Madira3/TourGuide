package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StayListFrag extends android.app.Fragment {


    public StayListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.list_item,container,false);

       final ArrayList<List> stayList = new ArrayList<>();

       stayList.add(new List(getString(R.string.crowne),R.drawable.crowne_plaza));
       stayList.add(new List(getString(R.string.extended_stay),R.drawable.extended_stay));
       stayList.add(new List(getString(R.string.marriot),R.drawable.marriot_suites));
       stayList.add(new List(getString(R.string.hyatt),R.drawable.hyatt));

       ListAdapter stayListAdapter = new ListAdapter(getActivity(),stayList);
        ListView stayListView = rootView.findViewById(R.id.list);
        stayListView.setAdapter(stayListAdapter);

        stayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CrownePlazaFragment()).addToBackStack(null).commit();


                }

                else if(position == 1){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExtendedStayFragment()).addToBackStack(null).commit();


                }

                else if(position == 2){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MarriotFragment()).addToBackStack(null).commit();

                }

                else{
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HyattFragment()).addToBackStack(null).commit();

                }

            }
        });




       return rootView;
    }

}
