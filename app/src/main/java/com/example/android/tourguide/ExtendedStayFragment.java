package com.example.android.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtendedStayFragment extends android.app.Fragment {

    CarouselView carouselView;
    int[] extendedStayImages = {R.drawable.extended_stay, R.drawable.extended_carousel1, R.drawable.extended_carousel2, R.drawable.extended_carousel3};

    private String url = "https://www.extendedstayamerica.com/hotels/dc/washington-dc/herndon-dulles";

    public ExtendedStayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.description_fragment, container, false);
        carouselView = rootView.findViewById(R.id.carouselView);
        carouselView.setPageCount(extendedStayImages.length);
        carouselView.setImageListener(imageListener);

        TextView headingText = rootView.findViewById(R.id.description_heading);
        headingText.setText(getString(R.string.extended_stay));

        TextView textView = rootView.findViewById(R.id.description_text);
        String data="";
        StringBuffer sb = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.extended_stay);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if(is != null){
            try{
                while((data= reader.readLine() )!= null){
                    sb.append(data+"\n");
                }
                textView.setText(sb);
                is.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        TextView urlText = rootView.findViewById(R.id.url_text);
        urlText.setText(url);
        urlText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        return rootView;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(extendedStayImages[position]);
        }
    };
}
