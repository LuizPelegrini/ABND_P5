package com.example.android.abnd_p5;


import android.content.res.Resources;
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

       Resources resources = getResources();

       attractions = new ArrayList<>();
       attractions.add(new Attraction(resources.getString(R.string.sentosa), R.drawable.sentosa));
       attractions.add(new Attraction(resources.getString(R.string.gardens_by_the_bay), R.drawable.gardens_by_the_bay));
       attractions.add(new Attraction(resources.getString(R.string.marina_bay_sands), R.drawable.marina_bay_sands));
       attractions.add(new Attraction(resources.getString(R.string.universal_studios), R.drawable.universal_studios));
       attractions.add(new Attraction(resources.getString(R.string.orchard_road), R.drawable.orchard_road));
       attractions.add(new Attraction(resources.getString(R.string.night_safari), R.drawable.night_safari));
       attractions.add(new Attraction(resources.getString(R.string.singapore_zoo), R.drawable.singapore_zoo));

       GridView gridView = rootView.findViewById(R.id.grid_view);
       AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
       gridView.setAdapter(adapter);

       return rootView;
    }

}
