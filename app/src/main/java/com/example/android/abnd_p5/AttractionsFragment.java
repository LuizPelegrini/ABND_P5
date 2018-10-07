package com.example.android.abnd_p5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    ArrayList<Attraction> attractions;

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.grid_layout, container, false);

       attractions = new ArrayList<>();
       attractions.add(new Attraction("Attraction A", R.drawable.ic_launcher_background));
       attractions.add(new Attraction("Attraction B", R.drawable.ic_launcher_background));
       attractions.add(new Attraction("Attraction C", R.drawable.ic_launcher_background));
       attractions.add(new Attraction("Attraction D", R.drawable.ic_launcher_background));
       attractions.add(new Attraction("Attraction E", R.drawable.ic_launcher_background));
       attractions.add(new Attraction("Attraction F", R.drawable.ic_launcher_background));

       GridView gridView = rootView.findViewById(R.id.grid_view);
       AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
       gridView.setAdapter(adapter);

       return rootView;
    }

}
